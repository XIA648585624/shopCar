package henu.rjxy.xmh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitAction extends HttpServlet{
	public void  service(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		HttpSession session = request.getSession();//
		session.invalidate();//Ïú»Ùµ±Ç°session
		response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		
	}
}	