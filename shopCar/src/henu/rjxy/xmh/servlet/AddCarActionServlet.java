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
		//获取前台数据
		HttpSession session = request.getSession();
		String strcarId= request.getParameter("carId");Integer carId = Integer.parseInt(strcarId);
		String carPname = request.getParameter("carPname");
		String carPath = request.getParameter("carPath");
		String strcarPrice = request.getParameter("carPrice");Double carPrice = Double.parseDouble(strcarPrice);
		Map<Integer,CarItem> cars = (Map<Integer,CarItem>)session.getAttribute("cars");//获取购物车信息
		Set<Integer> set = cars.keySet();
		boolean flag = false;//购物车是否有该商品的标记
		for (Integer id : set) {//遍历购物车
			if(id.equals(carId)) {
				CarItem pro = cars.get(id);//如果ID相等说明购物车中重复添加
				pro.setPronum(pro.getPronum()+1);//购物车中商品数量+1
				flag = true;
				System.out.println("重复添加商品："+carPname+":"+pro.getPronum());
			}
				
		}
		if(!flag) {//如果购物车中没有该商品
			System.out.println("首次添加商品："+carPname);
			CarItem newCarI = new CarItem(carId, carPname, carPrice, carPath, null, 1);
			cars.put(carId, newCarI);
		}
		session.setAttribute("cars", cars);//更新作用域
	/*	carId=${p.id}&carPname=${p.productname}&carPath=${path }${p.picpath}&carPrice=${p.price }*/
		request.setAttribute("addSccarName", carPname);
		request.getRequestDispatcher("/view/AddCarSuccess.jsp").forward(request, response);
	}
}
