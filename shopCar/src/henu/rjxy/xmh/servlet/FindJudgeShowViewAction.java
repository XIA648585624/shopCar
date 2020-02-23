package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.service.ProductService;
import henu.rjxy.xmh.service.impl.ProductServiceImpl;

public class FindJudgeShowViewAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//获取当前页数
		String strcurrentPage = request.getParameter("currentPage");//获取将要跳转的页码
		String strpageSize = request.getParameter("pageSize");//获取页面大小
		
		Integer currentPage = 1;//页码默认为1
		Integer pageSize = 5;
		if(strpageSize!=null) {//如果不是第一次请求分页
			pageSize = Integer.valueOf(strpageSize);
		}
		if(strcurrentPage!=null) {//如果不是第一次请求分页
			currentPage = Integer.valueOf(strcurrentPage);
		}
		
		List<Product> pros = (List<Product>) request.getAttribute("pros");//获取转发请求中的商品数量
		Integer pageNum = (Integer) request.getAttribute("pageNum");//获取总页数
		
		session.setAttribute("pageNum", pageNum);//将总页数存到session作用域
		session.setAttribute("pageSize", pageSize);//将页面大小存到session作用域
		session.setAttribute("currentPage", currentPage);//将当前页码存到session作用域
		//跳转到view
		session.setAttribute("pros", pros);//设置session作用域定义属性
		response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
	}
}
