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
		//获取前台数据
		//获取前台购物车中提交的oncarId的值
		String[] stroncarIds = request.getParameterValues("oncarId");
		
		Map<Integer,CarItem> newcars = new HashMap<Integer,CarItem>();//实际提交购物车信息
		HttpSession session = request.getSession();
		System.out.println("stroncarIds:"+stroncarIds);
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {//全部删除判断
			System.out.println("为空");
			//获取cars信息和oldcars信息
			Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
			Map<Integer,CarItem> oldcars  = new HashMap<Integer,CarItem>();
			//如果作用域中的oldcars不为null，此时将oldcars引用此定义属性
			if((Map<Integer,CarItem>)session.getAttribute("oldcars")!=null) {
				oldcars = (Map<Integer,CarItem>)session.getAttribute("oldcars");
			}
			
			//遍历cars剩下的信息，存到oldcars上，如果回收站（oldcars）已存在此商品将此商品的值加一
			Set<Integer> delIds = cars.keySet();
			for (Integer delId : delIds) {
				CarItem delcar  = cars.get(delId);
				if(oldcars.containsKey(delId)) {
					CarItem olddelcar = oldcars.get(delId);//取出此商品
					olddelcar.setPronum(olddelcar.getPronum()+1);//将此商品数量+1
				}else {//如果是第一次加入回收站
					oldcars.put(delId,delcar);
				}
					
			}
			session.setAttribute("cars", newcars);
			//跳转回购物车
			response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
			return;
		}
		String[] strpNums = request.getParameterValues("pronum");
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
		for(Integer oncarId:oncarIds) {//遍历oncarIds，将该id的购物车上面的信息存到newcars上面
			if(cars.containsKey(oncarId)) {
				CarItem carPro  = cars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//更新商品数量
				k++;
				newcars.put(oncarId,carPro);
				cars.remove(oncarId);//将此商品信息移除
			}
		}//此时cars中剩下的product就是从购物车移到回收站的商品
		//遍历cars剩下的信息，存到oldcars上，如果回收站（oldcars）已存在此商品将此商品的值加一
		Set<Integer> delIds = cars.keySet();
		for (Integer delId : delIds) {
			CarItem delcar  = cars.get(delId);
			if(oldcars.containsKey(delId)) {
				CarItem olddelcar = oldcars.get(delId);//取出此商品
				olddelcar.setPronum(olddelcar.getPronum()+1);//将此商品数量+1
			}else {//如果是第一次加入回收站
				oldcars.put(delId,delcar);
			}
				
		}
		//更新购物车信息
		session.setAttribute("cars", newcars);
		session.setAttribute("oldcars", oldcars);
		//跳转回购物车
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
}
