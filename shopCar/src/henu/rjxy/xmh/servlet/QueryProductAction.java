package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.service.ProductService;
import henu.rjxy.xmh.service.impl.ProductServiceImpl;

public class QueryProductAction  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//调用pservice方法
		ProductService ps = new ProductServiceImpl();
		List<Product> pros = ps.getAllProduct();
		//设置作用域定义属性
		request.getSession().setAttribute("pros", pros);
		response.sendRedirect(request.getContextPath()+"/view/QueryProductView.jsp");
	}
}
