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
		//获取前台数据
		//获取前台购物车中提交的oncarId的值
		String[] stroncarIds = request.getParameterValues("oncarId");
		
		Map<Integer,CarItem> newcars = new HashMap<Integer,CarItem>();
		HttpSession session = request.getSession();
		System.out.println("stroncarIds:"+stroncarIds);
		List<Integer> oncarIds = new ArrayList<Integer>();
		if(stroncarIds==null) {
			System.out.println("为空");
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
		//获取cars信息
		Map<Integer,CarItem> cars  = (Map<Integer,CarItem>)session.getAttribute("cars");
		
		int k = 0;
		for(Integer oncarId:oncarIds) {//遍历oncarIds，将该id的购物车上面的信息存到newcars上面
			if(cars.containsKey(oncarId)) {
				CarItem carPro  = cars.get(oncarId);
				carPro.setPronum(Integer.valueOf(strpNums[k]));//更新商品数量
				k++;
				newcars.put(oncarId,carPro);
			}
		}
		//更新购物车信息
		session.setAttribute("cars", newcars);
		//跳转回购物车
		response.sendRedirect(request.getContextPath()+"/view/ShopCarView.jsp");
	}
		
}
