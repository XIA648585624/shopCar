package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.CarItem;

public class AlterCarAction  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡǰ̨����
		//��ȡǰ̨���ﳵ���ύ��oncarId��ֵ
		String[] stroncarIds = request.getParameterValues("oncarId");
		
		Map<Integer,CarItem> newcars = new HashMap<Integer,CarItem>();
		HttpSession session = request.getSession();
		System.out.println("stroncarIds:"+stroncarIds);
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {
			System.out.println("Ϊ��");
			session.setAttribute("cars", newcars);
			//��ת�ع��ﳵ
			response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
			return;
		}
		String[] strpNums = request.getParameterValues("pronum");
		for (int i = 0; i < strpNums.length; i++) {
			System.out.println(strpNums[i]);
		}
		for (int i = 0; i < stroncarIds.length; i++) {
			oncarIds.add(Integer.parseInt(stroncarIds[i]));//������ת����Integer���ʹ浽oncarIds������
		}
		//��ȡcars��Ϣ
		Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
		
		int k = 0;
		for(Integer oncarId:oncarIds) {//����oncarIds������id�Ĺ��ﳵ�������Ϣ�浽newcars����
			if(cars.containsKey(oncarId)) {
				CarItem carPro  = cars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//������Ʒ����
				k++;
				newcars.put(oncarId,carPro);
			}
		}
		//���¹��ﳵ��Ϣ
		session.setAttribute("cars", newcars);
		//��ת�ع��ﳵ
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
		
}
