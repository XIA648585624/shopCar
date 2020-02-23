package henu.rjxy.xmh.test;

import java.util.List;

import org.junit.Test;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.dao.ProductDao;
import henu.rjxy.xmh.dao.UserDao;
import henu.rjxy.xmh.dao.impl.ProductDaoImpl;
import henu.rjxy.xmh.dao.impl.UserDaoImpl;
import henu.rjxy.xmh.util.JDBCUtil;

public class TestConn {

	@Test
	public void testConn1() {
		System.out.println(JDBCUtil.getConnection());
	}

	@Test
	public void testProDao() {
		ProductDao dao = new ProductDaoImpl();
		System.out.println(dao.getProductByMinForPriceCount(50D));
		List<Product> list =  dao.selectProductByMinForPrice(50D, 1, 3);
		for (Product p : list) {
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testUserDao() {
		UserDao dao = new UserDaoImpl();
		/*List<Product> list =  dao.selectAllProduct();
		for (Product p : list) {
			System.out.println(p);
		}*/
		/*System.out.println(dao.login("luxw", "1234"));*/
		/*dao.insertUser(new User("xmh","123456","夏铭鸿",100000,"万源路"));*/
		/*dao.updateUser( new User("xmh","123456","夏铭鸿太帅了吧",100000,"万源路"));*/
		/*dao.updatePassword("xmh", "123");*/
		
	}
}
