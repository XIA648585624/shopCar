package henu.rjxy.xmh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.dao.ProductDao;
import henu.rjxy.xmh.util.JDBCUtil;
/*名称                                      是否为空? 类型
		 ----------------------------------------- -------- ----------------------------
		 ID                                        NOT NULL NUMBER(7)
		 PRODUCTNAME                               NOT NULL VARCHAR2(20)
		 PRICE                                              NUMBER(7,2)
		 PICPATH                                            VARCHAR2(40)
		 DISCRIPTION                                        VARCHAR2(40)*/
public class ProductDaoImpl implements ProductDao{

	//分页查询
	@Override
	public List<Product> selectProductByPage(Integer begin,Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from "
					+ "(select p.*,rownum rn from SHOP_PRODUCT p ) where rn>=? and  rn<=?";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setInt(1, begin);
			 pstm.setInt(2, end);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询所有商品信息失败");
			throw new RuntimeException("查询所有商品信息失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
		
	}

	//查询所有商品信息
	@Override
	public List<Product> selectAllProduct() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from  SHOP_PRODUCT ";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询所有商品信息失败");
			throw new RuntimeException("查询所有商品信息失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//根据商品名模糊查询
	@Override
	public List<Product> selectProductByPname(String pName) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRODUCTNAME like '%'||?||'%'";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setString(1, pName);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询所有商品信息失败");
			throw new RuntimeException("查询所有商品信息失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//查询大于该价格的商品信息
	@Override
	public List<Product> selectProductByMaxForPrice(Double begin) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRICE >=?";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setDouble(1, begin);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询所有商品信息失败");
			throw new RuntimeException("查询所有商品信息失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//查询小于该价格的商品信息
	@Override
	public List<Product> selectProductByMinForPrice(Double end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRICE <=?";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setDouble(1, end);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询所有商品信息失败");
			throw new RuntimeException("查询所有商品信息失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	
	//查询当前表product信息个数
	@Override
	public Integer selectProductCount() {
		Connection conn =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from SHOP_PRODUCT";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;//返回当前表格product信息的个数
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//根据商品名称查询（分页）
	@Override
	public List<Product> selectProductByPname(String pName, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRODUCTNAME  like '%'||?||'%' " + 
					" ) where rn>=? and rn<=?";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setString(1, pName);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询根据商品名称查询（分页）失败");
			throw new RuntimeException("查询根据商品名称查询（分页）失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//获取根据商品名查询的信息条数
	@Override
	public Integer getForProductByPnameCount(String pName) {
		Connection conn =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from shop_product p where PRODUCTNAME  like '%'||?||'%'";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pName);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;//返回当前表格product信息的个数
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//根据大于该价格查询(分页)
	@Override
	public List<Product> selectProductByMaxForPrice(Double beginPrice, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRICE >= ? " + 
					" ) where rn>=? and rn<=? ";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setDouble(1, beginPrice);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询大于该价格查询(分页)失败");
			throw new RuntimeException("查询大于该价格查询(分页)失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//获取根据大于该价格查询(分页)信息条数
	@Override
	public Integer getProductByMaxForPriceCount(Double beginPrice) {
		Connection conn =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from shop_product p where PRICE >= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, beginPrice);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;//返回当前表格product信息的个数
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//根据小于该区间查询
	@Override
	public List<Product> selectProductByMinForPrice(Double endPrice, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//书写SQL语句
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRICE <= ? " + 
					" ) where rn>=? and rn<=? ";
			 pstm = conn.prepareStatement(sql);//创建PreparedStatement
			//执行SQL语句
			 pstm.setDouble(1, endPrice);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//接收结果集
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
				products.add(p);
			}
			return products;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询大于该价格查询(分页)失败");
			throw new RuntimeException("查询大于该价格查询(分页)失败");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//根据小于该区间查询(分页)
	@Override
	public Integer getProductByMinForPriceCount(Double endPrice) {
		Connection conn =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from shop_product p where PRICE <= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, endPrice);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;//返回当前表格product信息的个数
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

}
