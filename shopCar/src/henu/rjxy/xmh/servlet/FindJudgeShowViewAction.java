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
		
		List<Product> pros = (List<Product>) request.getAttribute("pros");//��ȡת�������е���Ʒ����
		Integer pageNum = (Integer) request.getAttribute("pageNum");//��ȡ��ҳ��
		
		session.setAttribute("pageNum", pageNum);//����ҳ���浽session������
		session.setAttribute("pageSize", pageSize);//��ҳ���С�浽session������
		session.setAttribute("currentPage", currentPage);//����ǰҳ��浽session������
		//��ת��view
		session.setAttribute("pros", pros);//����session������������
		response.sendRedirect(request.getContextPath()+"/view/FindPage.jsp");
	}
}
