package henu.rjxy.xmh.test;

import java.util.List;

import org.junit.Test;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.service.ProductService;
import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.service.impl.ProductServiceImpl;
import henu.rjxy.xmh.service.impl.UserServiceImpl;

public class TestService {
	@Test
	public void testUserService() {
		UserService us = new UserServiceImpl();
		/*us.Login("xmh", "123");
		us.alterUser(new User("xmh","123456","夏铭鸿太帅了吧",100000,"万源路"));*/
		/*System.out.println(us.createUser(new User("xmh2","123456","夏铭鸿太帅了吧1",100000,"万源路")));*/
	}
	
	@Test
	public void testProService() {
		ProductService ps = new ProductServiceImpl();
		System.out.println(ps.getPageNumForAllByMinPrice(50D, 3));
		List<Product> list = ps.getAllByMinPrice(50D, 1, 3);
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
