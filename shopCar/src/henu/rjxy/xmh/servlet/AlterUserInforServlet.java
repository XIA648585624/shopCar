package henu.rjxy.xmh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.service.impl.UserServiceImpl;

public class AlterUserInforServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String strzip = request.getParameter("zip");
		Integer zip = Integer.parseInt(strzip);
		//调用业务方法
		UserService us = new UserServiceImpl();
		User user = new User(username, password, name, zip, address);
		if(us.alterUser(user)) {
			//修改成功
			HttpSession session = request.getSession();//获取session
			session.setAttribute("loginMsg", user);//更新作用域中的信息
			response.sendRedirect(request.getContextPath()+"/view/ChangeUserMessageSuccess.jsp");
		}else {
			request.setAttribute("alterUserInforError", "用户信息修改失败");
			request.getRequestDispatcher("/view/ChangeUserMessageView.jsp").forward(request, response);;
		}
	}
}
