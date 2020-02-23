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

public class AlterCarForBackAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡǰ̨����
		//��ȡǰ̨���ﳵ���ύ��oncarId��ֵ
		String[] stroncarIds = request.getParameterValues("oncarIddel");
		
		Map<Integer,CarItem> newoldcars = new HashMap<Integer,CarItem>();//�洢ʵ���ύ����վ����Ϣ
		HttpSession session = request.getSession();
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {//ȫ��ɾ���ж�
			System.out.println("---------stroncarIds==null-----------");
			//��oldcars��������Ϣȫ���Ƶ�cars��
			Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
			Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
			//����������е�oldcars��Ϊnull����ʱ��oldcars���ô˶�������
			if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
				oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
			}
			
			//����oldcarsʣ�µ���Ϣ���浽cars�ϣ�������ﳵ��cars���Ѵ��ڴ���Ʒ������Ʒ��ֵ��һ
			Set<Integer> delIds = oldcars.keySet();
			for (Integer delId : delIds) {
				CarItem delcar  = oldcars.get(delId);
				if(cars.containsKey(delId)) {
					CarItem car = cars.get(delId);//ȡ������Ʒ
					car.setPronum(car.getPronum()+1);//������Ʒ����+1
				}else {//������ﳵû�д���Ʒ
					cars.put(delId,delcar);
				}
					
			}
			session.setAttribute("oldcars", newoldcars);
			//��ת�ع��ﳵ
			response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
			return;
		}
		String[] strpNums = request.getParameterValues("pronum");//����
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
		for(Integer oncarId:oncarIds) {//����oncarIds������id�Ļ���վ�������Ϣ�浽newoldcars����
			if(oldcars.containsKey(oncarId)) {
				CarItem carPro  = oldcars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//������Ʒ����
				k++;
				newoldcars.put(oncarId,carPro);
				oldcars.remove(oncarId);//������Ʒ��Ϣ�Ƴ�
			}
		}//��ʱoldcars��ʣ�µ�product���Ǵӻ���վ�ƶ������ﳵ����Ʒ
		//����oldcarsʣ�µ���Ϣ���浽cars�ϣ��������վ��cars���Ѵ��ڴ���Ʒ������Ʒ��ֵ��һ
		Set<Integer> delIds = oldcars.keySet();
		for (Integer delId : delIds) {
			CarItem delcar  = oldcars.get(delId);
			if(cars.containsKey(delId)) {
				CarItem car = cars.get(delId);//ȡ������Ʒ
				car.setPronum(car.getPronum()+1);//������Ʒ����+1
			}else {//������ﳵû�д���Ʒ
				cars.put(delId,delcar);
			}
				
		}
		//���¹��ﳵ��Ϣ
		System.out.println("end,cars:"+cars);
		session.setAttribute("cars", cars);
		session.setAttribute("oldcars", newoldcars);
		//��ת�ع��ﳵ
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
}
