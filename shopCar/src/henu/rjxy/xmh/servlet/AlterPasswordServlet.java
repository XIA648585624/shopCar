package henu.rjxy.xmh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.service.impl.UserServiceImpl;

public class AlterPasswordServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPass");
		String password = request.getParameter("newPass1");
		String pass2 = request.getParameter("newPass2");
		//如果两次密码不一致
		if(!password.equals(pass2)) {
			request.setAttribute("loginPassError", "两次密码不一致!");
			System.out.println("两次新密码不一致");
			request.getRequestDispatcher("/view/ChangePasswordView.jsp").forward(request, response);
			return;
		}
		UserService us = new UserServiceImpl();
		//重定向到密码修改成功页面
		if(us.alterPassword(username, oldPassword, password)) {
			request.setAttribute("changeMsg", password);
			request.getRequestDispatcher("/view/ChangePasswordSuccess.jsp").forward(request, response);
		}else {
			request.setAttribute("loginOldPassError", "密码错误!");
			System.out.println("密码错误!");
			request.getRequestDispatcher("/view/ChangePasswordView.jsp").forward(request, response);
		}
	}
}
