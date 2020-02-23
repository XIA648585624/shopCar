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
		//��ȡǰ̨�������ύ������
		String pName = request.getParameter("productName");
		String opt = request.getParameter("opt");
		String price = request.getParameter("price");
		
		//��ȡ��ǰҳ��
		String strcurrentPage = request.getParameter("currentPage");//��ȡ��Ҫ��ת��ҳ��
		String strpageSize = request.getParameter("pageSize");//��ȡҳ���С
		
		Integer currentPage = 1;//ҳ��Ĭ��Ϊ1
		Integer pageSize = 5;
		if(strpageSize!=null) {//������ǵ�һ�������ҳ
			pageSize = Integer.valueOf(strpageSize);
		}
		if(strcurrentPage!=null) {//������ǵ�һ�������ҳ
			currentPage = Integer.valueOf(strcurrentPage);
		}
		
		
		//�ж�������ʽ
		//System.out.println("pName"+(pName=="")+",opt"+opt+",price"+(price==""));
		ProductService ps = new ProductServiceImpl();
		if(pName!=""&&price!="") {
			//1.productName��price����ֵʱ��ת��QueryProductByPnameAndM	
			
		}else if(pName!=""&&price=="") {
			//2.��productName��ֵ��priceΪ""ʱ��������������
			System.out.println("QueryJudgeServlet:����pName���ң�"+pName);
			List<Product> pros = ps.getAllByLikePname(pName, currentPage, pageSize);//��ȡ��ҳ��ѯ����Ϣ
			Integer pageNum =ps.getPageNumForAllByLikePname(pName, pageSize);//��ȡ��ҳ��
			
			session.setAttribute("pageNum", pageNum);//����ҳ���浽session������
			session.setAttribute("pageSize", pageSize);//��ҳ���С�浽session������
			session.setAttribute("currentPage", currentPage);//����ǰҳ��浽session������
			session.setAttribute("pros", pros);//��ȡ��ҳ��ѯ����Ϣ�浽������
			
			response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
		}else if(pName==""&&price!="") {
			//3.��pNameΪ""��price��ֵʱ��ת��QueryProductByMax����QueryProductByMin
			if(opt.equals("1")) {
				System.out.println("QueryJudgeServlet:����С��end���ң�"+price);
				Double end = Double.parseDouble(price);//ת����ʽ
				List<Product> pros = ps.getAllByMinPrice(end, currentPage, pageSize);
				Integer pageNum =ps.getPageNumForAllByMinPrice(end, pageSize);
				
				session.setAttribute("pageNum", pageNum);//����ҳ���浽session������
				session.setAttribute("pageSize", pageSize);//��ҳ���С�浽session������
				session.setAttribute("currentPage", currentPage);//����ǰҳ��浽session������
				session.setAttribute("pros", pros);//��ȡ��ҳ��ѯ����Ϣ�浽������
				
				response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
			}else if(opt.equals("2")){
				System.out.println("QueryJudgeServlet:���ݴ���begin���ң�"+price);
				Double begin = Double.parseDouble(price);//ת����ʽ
				List<Product> pros = ps.getAllByMaxPrice(begin, currentPage, pageSize);
				Integer pageNum =ps.getPageNumForAllByMaxPrice(begin, pageSize);
				
				session.setAttribute("pageNum", pageNum);//����ҳ���浽session������
				session.setAttribute("pageSize", pageSize);//��ҳ���С�浽session������
				session.setAttribute("currentPage", currentPage);//����ǰҳ��浽session������
				session.setAttribute("pros", pros);//��ȡ��ҳ��ѯ����Ϣ�浽������
				
				response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
			}
		}else {
			//4.��pName��price��Ϊ""ʱ����ת��FindProductPageAction
			response.sendRedirect(request.getContextPath()+"/view/FindProductPageAction");
		}
		
		
	}
}
