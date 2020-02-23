package henu.rjxy.xmh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.dao.ProductDao;
import henu.rjxy.xmh.util.JDBCUtil;
/*����                                      �Ƿ�Ϊ��? ����
		 ----------------------------------------- -------- ----------------------------
		 ID                                        NOT NULL NUMBER(7)
		 PRODUCTNAME                               NOT NULL VARCHAR2(20)
		 PRICE                                              NUMBER(7,2)
		 PICPATH                                            VARCHAR2(40)
		 DISCRIPTION                                        VARCHAR2(40)*/
public class ProductDaoImpl implements ProductDao{

	//��ҳ��ѯ
	@Override
	public List<Product> selectProductByPage(Integer begin,Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from "
					+ "(select p.*,rownum rn from SHOP_PRODUCT p ) where rn>=? and  rn<=?";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setInt(1, begin);
			 pstm.setInt(2, end);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ��Ϣʧ��");
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
		
	}

	//��ѯ������Ʒ��Ϣ
	@Override
	public List<Product> selectAllProduct() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from  SHOP_PRODUCT ";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ��Ϣʧ��");
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//������Ʒ��ģ����ѯ
	@Override
	public List<Product> selectProductByPname(String pName) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRODUCTNAME like '%'||?||'%'";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setString(1, pName);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ��Ϣʧ��");
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//��ѯ���ڸü۸����Ʒ��Ϣ
	@Override
	public List<Product> selectProductByMaxForPrice(Double begin) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRICE >=?";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setDouble(1, begin);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ��Ϣʧ��");
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//��ѯС�ڸü۸����Ʒ��Ϣ
	@Override
	public List<Product> selectProductByMinForPrice(Double end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select ID,PRODUCTNAME,PRICE,PICPATH,DISCRIPTION from SHOP_PRODUCT "
					+ " where PRICE <=?";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setDouble(1, end);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ��Ϣʧ��");
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	
	//��ѯ��ǰ��product��Ϣ����
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
			return count;//���ص�ǰ���product��Ϣ�ĸ���
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//������Ʒ���Ʋ�ѯ����ҳ��
	@Override
	public List<Product> selectProductByPname(String pName, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRODUCTNAME  like '%'||?||'%' " + 
					" ) where rn>=? and rn<=?";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setString(1, pName);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ������Ʒ���Ʋ�ѯ����ҳ��ʧ��");
			throw new RuntimeException("��ѯ������Ʒ���Ʋ�ѯ����ҳ��ʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//��ȡ������Ʒ����ѯ����Ϣ����
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
			return count;//���ص�ǰ���product��Ϣ�ĸ���
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//���ݴ��ڸü۸��ѯ(��ҳ)
	@Override
	public List<Product> selectProductByMaxForPrice(Double beginPrice, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRICE >= ? " + 
					" ) where rn>=? and rn<=? ";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setDouble(1, beginPrice);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ���ڸü۸��ѯ(��ҳ)ʧ��");
			throw new RuntimeException("��ѯ���ڸü۸��ѯ(��ҳ)ʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//��ȡ���ݴ��ڸü۸��ѯ(��ҳ)��Ϣ����
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
			return count;//���ص�ǰ���product��Ϣ�ĸ���
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//����С�ڸ������ѯ
	@Override
	public List<Product> selectProductByMinForPrice(Double endPrice, Integer begin, Integer end) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//��дSQL���
			String sql = "select * from(select p.*,rownum rn from shop_product p where PRICE <= ? " + 
					" ) where rn>=? and rn<=? ";
			 pstm = conn.prepareStatement(sql);//����PreparedStatement
			//ִ��SQL���
			 pstm.setDouble(1, endPrice);
			 pstm.setInt(2, begin);
			 pstm.setInt(3, end);
			rs = pstm.executeQuery();
			//���ս����
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
			System.out.println("��ѯ���ڸü۸��ѯ(��ҳ)ʧ��");
			throw new RuntimeException("��ѯ���ڸü۸��ѯ(��ҳ)ʧ��");
		}finally {
			JDBCUtil.close(rs, pstm, null);
		}
	}

	//����С�ڸ������ѯ(��ҳ)
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
			return count;//���ص�ǰ���product��Ϣ�ĸ���
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��");
		}finally{
			JDBCUtil.close(rs, pstm, null);
		}
	}

}
