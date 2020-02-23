package henu.rjxy.xmh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.service.impl.UserServiceImpl;

public class CreateUserActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
		String username = request.getParameter("username");
		String password = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		//如果两次密码不一致
		if(!password.equals(pass2)) {
			request.setAttribute("loginPassError", "两次密码不一致!");
			System.out.println("两次密码不一致");
			//request.getRequestDispatcher("/view/CreateUserView.jsp").forward(request, response);
		}
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String strzip = request.getParameter("zip");
		Integer zip = Integer.parseInt(strzip);
		//调用业务方法
		UserService us = new UserServiceImpl();
		if(us.createUser(new User(username, password, name, zip, address))) {
			//创建成功
			response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		}else {
			request.setAttribute("loginUserError", "用户名已存在！");
			request.getRequestDispatcher("/view/CreateUserView.jsp").forward(request, response);;
		}
	}
}
