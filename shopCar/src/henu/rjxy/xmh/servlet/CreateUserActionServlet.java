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
		//��ȡǰ̨����
		String username = request.getParameter("username");
		String password = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		//����������벻һ��
		if(!password.equals(pass2)) {
			request.setAttribute("loginPassError", "�������벻һ��!");
			System.out.println("�������벻һ��");
			//request.getRequestDispatcher("/view/CreateUserView.jsp").forward(request, response);
		}
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String strzip = request.getParameter("zip");
		Integer zip = Integer.parseInt(strzip);
		//����ҵ�񷽷�
		UserService us = new UserServiceImpl();
		if(us.createUser(new User(username, password, name, zip, address))) {
			//�����ɹ�
			response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		}else {
			request.setAttribute("loginUserError", "�û����Ѵ��ڣ�");
			request.getRequestDispatcher("/view/CreateUserView.jsp").forward(request, response);;
		}
	}
}
