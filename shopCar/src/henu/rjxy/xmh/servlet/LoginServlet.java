package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.CarItem;
import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();//获取session
		//设置默认的分页大小
		session.setAttribute("pageSize", 5);
		session.setAttribute("currentPage", 1);
		//调用service方法
		UserService us = new  UserServiceImpl();
		User user = us.Login(username, password);
		if(user!=null) {
			//登陆成功
			session.setAttribute("loginMsg", user);
			session.setAttribute("cars", new HashMap<Integer,CarItem>());//向session作用域中定义购物车属性
			System.out.println("LoginServlet:"+user.getName()+"登录成功~");
			response.sendRedirect(request.getContextPath()+"/view/FindProductPageAction");
		}else {
			response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		}
	}
}
