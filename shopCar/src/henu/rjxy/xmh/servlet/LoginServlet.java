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
		//��ȡǰ̨����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();//��ȡsession
		//����Ĭ�ϵķ�ҳ��С
		session.setAttribute("pageSize", 5);
		session.setAttribute("currentPage", 1);
		//����service����
		UserService us = new  UserServiceImpl();
		User user = us.Login(username, password);
		if(user!=null) {
			//��½�ɹ�
			session.setAttribute("loginMsg", user);
			session.setAttribute("cars", new HashMap<Integer,CarItem>());//��session�������ж��幺�ﳵ����
			System.out.println("LoginServlet:"+user.getName()+"��¼�ɹ�~");
			response.sendRedirect(request.getContextPath()+"/view/FindProductPageAction");
		}else {
			response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		}
	}
}
