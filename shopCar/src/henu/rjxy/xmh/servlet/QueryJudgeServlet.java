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

public class QueryJudgeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//获取前台搜索表单提交的数据
		String pName = request.getParameter("productName");
		String opt = request.getParameter("opt");
		String price = request.getParameter("price");
		
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
		
		
		//判断搜索方式
		//System.out.println("pName"+(pName=="")+",opt"+opt+",price"+(price==""));
		ProductService ps = new ProductServiceImpl();
		if(pName!=""&&price!="") {
			//1.productName和price都有值时跳转到QueryProductByPnameAndM	
			
		}else if(pName!=""&&price=="") {
			//2.当productName有值且price为""时，根据姓名查找
			System.out.println("QueryJudgeServlet:根据pName查找："+pName);
			List<Product> pros = ps.getAllByLikePname(pName, currentPage, pageSize);//获取分页查询的信息
			Integer pageNum =ps.getPageNumForAllByLikePname(pName, pageSize);//获取总页数
			
			session.setAttribute("pageNum", pageNum);//将总页数存到session作用域
			session.setAttribute("pageSize", pageSize);//将页面大小存到session作用域
			session.setAttribute("currentPage", currentPage);//将当前页码存到session作用域
			session.setAttribute("pros", pros);//获取分页查询的信息存到作用域
			
			response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
		}else if(pName==""&&price!="") {
			//3.当pName为""且price有值时跳转到QueryProductByMax或者QueryProductByMin
			if(opt.equals("1")) {
				System.out.println("QueryJudgeServlet:根据小于end查找："+price);
				Double end = Double.parseDouble(price);//转换格式
				List<Product> pros = ps.getAllByMinPrice(end, currentPage, pageSize);
				Integer pageNum =ps.getPageNumForAllByMinPrice(end, pageSize);
				
				session.setAttribute("pageNum", pageNum);//将总页数存到session作用域
				session.setAttribute("pageSize", pageSize);//将页面大小存到session作用域
				session.setAttribute("currentPage", currentPage);//将当前页码存到session作用域
				session.setAttribute("pros", pros);//获取分页查询的信息存到作用域
				
				response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
			}else if(opt.equals("2")){
				System.out.println("QueryJudgeServlet:根据大于begin查找："+price);
				Double begin = Double.parseDouble(price);//转换格式
				List<Product> pros = ps.getAllByMaxPrice(begin, currentPage, pageSize);
				Integer pageNum =ps.getPageNumForAllByMaxPrice(begin, pageSize);
				
				session.setAttribute("pageNum", pageNum);//将总页数存到session作用域
				session.setAttribute("pageSize", pageSize);//将页面大小存到session作用域
				session.setAttribute("currentPage", currentPage);//将当前页码存到session作用域
				session.setAttribute("pros", pros);//获取分页查询的信息存到作用域
				
				response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
			}
		}else {
			//4.当pName和price都为""时，跳转到FindProductPageAction
			response.sendRedirect(request.getContextPath()+"/view/FindProductPageAction");
		}
		
		
	}
}
