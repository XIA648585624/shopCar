package henu.rjxy.xmh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		
		Object o = session.getAttribute("loginMsg");
		//ÅÐ¶ÏµÇÂ¼×´Ì¬
		if(o==null) {
			response.sendRedirect(request.getContextPath()+"/LoginView.jsp");
		}else {//ÏòÏÂÖ´ÐÐ
			chain.doFilter(request, response);
		}
		
	}
	
}
