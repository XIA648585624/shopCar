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
		//��ȡǰ̨����
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPass");
		String password = request.getParameter("newPass1");
		String pass2 = request.getParameter("newPass2");
		//����������벻һ��
		if(!password.equals(pass2)) {
			request.setAttribute("loginPassError", "�������벻һ��!");
			System.out.println("���������벻һ��");
			request.getRequestDispatcher("/view/ChangePasswordView.jsp").forward(request, response);
			return;
		}
		UserService us = new UserServiceImpl();
		//�ض��������޸ĳɹ�ҳ��
		if(us.alterPassword(username, oldPassword, password)) {
			request.setAttribute("changeMsg", password);
			request.getRequestDispatcher("/view/ChangePasswordSuccess.jsp").forward(request, response);
		}else {
			request.setAttribute("loginOldPassError", "�������!");
			System.out.println("�������!");
			request.getRequestDispatcher("/view/ChangePasswordView.jsp").forward(request, response);
		}
	}
}
