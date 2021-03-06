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
		//获取前台数据
		//获取前台购物车中提交的oncarId的值
		String[] stroncarIds = request.getParameterValues("oncarIddel");
		
		Map<Integer,CarItem> newoldcars = new HashMap<Integer,CarItem>();//存储实际提交回收站的信息
		HttpSession session = request.getSession();
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {//全部删除判断
			System.out.println("---------stroncarIds==null-----------");
			//将oldcars的所有信息全部移到cars中
			Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
			Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
			//如果作用域中的oldcars不为null，此时将oldcars引用此定义属性
			if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
				oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
			}
			
			//遍历oldcars剩下的信息，存到cars上，如果购物车（cars）已存在此商品将此商品的值加一
			Set<Integer> delIds = oldcars.keySet();
			for (Integer delId : delIds) {
				CarItem delcar  = oldcars.get(delId);
				if(cars.containsKey(delId)) {
					CarItem car = cars.get(delId);//取出此商品
					car.setPronum(car.getPronum()+1);//将此商品数量+1
				}else {//如果购物车没有此商品
					cars.put(delId,delcar);
				}
					
			}
			session.setAttribute("oldcars", newoldcars);
			//跳转回购物车
			response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
			return;
		}
		String[] strpNums = request.getParameterValues("pronum");//数量
		for (int i = 0; i < strpNums.length; i++) {
			System.out.println(strpNums[i]);
		}
		for (int i = 0; i < stroncarIds.length; i++) {
			oncarIds.add(Integer.parseInt(stroncarIds[i]));//将数据转换成Integer类型存到oncarIds集合中
		}
		//获取cars信息和oldcars信息
		Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
		Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
		//如果作用域中的oldcars不为null，此时将oldcars引用此定义属性
		if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
			oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
		}
		int k = 0;
		for(Integer oncarId:oncarIds) {//遍历oncarIds，将该id的回收站上面的信息存到newoldcars上面
			if(oldcars.containsKey(oncarId)) {
				CarItem carPro  = oldcars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//更新商品数量
				k++;
				newoldcars.put(oncarId,carPro);
				oldcars.remove(oncarId);//将此商品信息移除
			}
		}//此时oldcars中剩下的product就是从回收站移动到购物车的商品
		//遍历oldcars剩下的信息，存到cars上，如果回收站（cars）已存在此商品将此商品的值加一
		Set<Integer> delIds = oldcars.keySet();
		for (Integer delId : delIds) {
			CarItem delcar  = oldcars.get(delId);
			if(cars.containsKey(delId)) {
				CarItem car = cars.get(delId);//取出此商品
				car.setPronum(car.getPronum()+1);//将此商品数量+1
			}else {//如果购物车没有此商品
				cars.put(delId,delcar);
			}
				
		}
		//更新购物车信息
		System.out.println("end,cars:"+cars);
		session.setAttribute("cars", cars);
		session.setAttribute("oldcars", newoldcars);
		//跳转回购物车
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
}
