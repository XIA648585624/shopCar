package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.CarItem;

public class AlterCarActionForDelServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡǰ̨����
		//��ȡǰ̨���ﳵ���ύ��oncarId��ֵ
		String[] stroncarIds = request.getParameterValues("oncarId");
		
		Map<Integer,CarItem> newcars = new HashMap<Integer,CarItem>();//ʵ���ύ���ﳵ��Ϣ
		HttpSession session = request.getSession();
		System.out.println("stroncarIds:"+stroncarIds);
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {//ȫ��ɾ���ж�
			System.out.println("Ϊ��");
			//��ȡcars��Ϣ��oldcars��Ϣ
			Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
			Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
			//����������е�oldcars��Ϊnull����ʱ��oldcars���ô˶�������
			if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
				oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
			}
			
			//����carsʣ�µ���Ϣ���浽oldcars�ϣ��������վ��oldcars���Ѵ��ڴ���Ʒ������Ʒ��ֵ��һ
			Set<Integer> delIds = cars.keySet();
			for (Integer delId : delIds) {
				CarItem delcar  = cars.get(delId);
				if(oldcars.containsKey(delId)) {
					CarItem olddelcar = oldcars.get(delId);//ȡ������Ʒ
					olddelcar.setPronum(olddelcar.getPronum()+1);//������Ʒ����+1
				}else {//����ǵ�һ�μ������վ
					oldcars.put(delId,delcar);
				}
					
			}
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
		//��ȡcars��Ϣ��oldcars��Ϣ
		Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
		Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
		//����������е�oldcars��Ϊnull����ʱ��oldcars���ô˶�������
		if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
			oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
		}
		int k = 0;
		for(Integer oncarId:oncarIds) {//����oncarIds������id�Ĺ��ﳵ�������Ϣ�浽newcars����
			if(cars.containsKey(oncarId)) {
				CarItem carPro  = cars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//������Ʒ����
				k++;
				newcars.put(oncarId,carPro);
				cars.remove(oncarId);//������Ʒ��Ϣ�Ƴ�
			}
		}//��ʱcars��ʣ�µ�product���Ǵӹ��ﳵ�Ƶ�����վ����Ʒ
		//����carsʣ�µ���Ϣ���浽oldcars�ϣ��������վ��oldcars���Ѵ��ڴ���Ʒ������Ʒ��ֵ��һ
		Set<Integer> delIds = cars.keySet();
		for (Integer delId : delIds) {
			CarItem delcar  = cars.get(delId);
			if(oldcars.containsKey(delId)) {
				CarItem olddelcar = oldcars.get(delId);//ȡ������Ʒ
				olddelcar.setPronum(olddelcar.getPronum()+1);//������Ʒ����+1
			}else {//����ǵ�һ�μ������վ
				oldcars.put(delId,delcar);
			}
				
		}
		//���¹��ﳵ��Ϣ
		session.setAttribute("cars", newcars);
		session.setAttribute("oldcars", oldcars);
		//��ת�ع��ﳵ
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
}
