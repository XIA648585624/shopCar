package henu.rjxy.xmh.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.rjxy.xmh.bean.CarItem;
import henu.rjxy.xmh.service.ProductService;
import henu.rjxy.xmh.service.impl.ProductServiceImpl;

public class AddCarActionServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡǰ̨����
		HttpSession session = request.getSession();
		String strcarId= request.getParameter("carId");Integer carId = Integer.parseInt(strcarId);
		String carPname = request.getParameter("carPname");
		String carPath = request.getParameter("carPath");
		String strcarPrice = request.getParameter("carPrice");Double carPrice = Double.parseDouble(strcarPrice);
		Map<Integer,CarItem> cars = (Map<Integer,CarItem>)session.getAttribute("cars");//��ȡ���ﳵ��Ϣ
		Set<Integer> set = cars.keySet();
		boolean flag = false;//���ﳵ�Ƿ��и���Ʒ�ı��
		for (Integer id : set) {//�������ﳵ
			if(id.equals(carId)) {
				CarItem pro = cars.get(id);//���ID���˵�����ﳵ���ظ����
				pro.setPronum(pro.getPronum()+1);//���ﳵ����Ʒ����+1
				flag = true;
				System.out.println("�ظ������Ʒ��"+carPname+":"+pro.getPronum());
			}
				
		}
		if(!flag) {//������ﳵ��û�и���Ʒ
			System.out.println("�״������Ʒ��"+carPname);
			CarItem newCarI = new CarItem(carId, carPname, carPrice, carPath, null, 1);
			cars.put(carId, newCarI);
		}
		session.setAttribute("cars", cars);//����������
	/*	carId=${p.id}&carPname=${p.productname}&carPath=${path }${p.picpath}&carPrice=${p.price }*/
		request.setAttribute("addSccarName", carPname);
		request.getRequestDispatcher("/view/AddCarSuccess.jsp").forward(request, response);
	}
}
