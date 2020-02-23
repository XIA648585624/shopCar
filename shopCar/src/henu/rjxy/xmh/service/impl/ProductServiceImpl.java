package henu.rjxy.xmh.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import henu.rjxy.xmh.bean.Product;
import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.dao.ProductDao;
import henu.rjxy.xmh.dao.impl.ProductDaoImpl;
import henu.rjxy.xmh.service.ProductService;
import henu.rjxy.xmh.util.JDBCUtil;

public class ProductServiceImpl implements ProductService{
	private static ProductDao dao  = new ProductDaoImpl();
	//��ȡ������Ʒ��Ϣ
	@Override
	public List<Product> getAllProduct() {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectAllProduct();
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}
	
	//������Ʒ��ģ����ѯ��Ʒ��Ϣ
	@Override
	public List<Product> getAllByLikePname(String pName) {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByPname(pName);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}
	
	//��ѯ�۸����begin��Ʒ��Ϣ
	@Override
	public List<Product> getAllByMaxPrice(Double begin) {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByMaxForPrice(begin);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}
	
	//��ѯ�۸�С��begin��Ʒ��Ϣ
	@Override
	public List<Product> getAllByMinPrice(Double end) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByMinForPrice(end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//��ҳ��ѯ
	@Override
	public List<Product> findProByPage(Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//��ʼ���
			Integer end = (currentPage)*pageSize;//�������
			List<Product> pros = dao.selectProductByPage(begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//��ȡ��ǰproduct�ĸ���
	@Override
	public Integer getPageNum(Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer count =dao.selectProductCount();
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ȡ��Ϣ����ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//2.2������Ʒ��ģ����ѯ��Ʒ��Ϣ����ҳ��
	@Override
	public List<Product> getAllByLikePname(String pName,Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//��ʼ���
			Integer end = (currentPage)*pageSize;//�������
			List<Product> pros = dao.selectProductByPname(pName, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("2.2������Ʒ��ģ����ѯ��Ʒ��Ϣ����ҳ��ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//2.3��ø�����Ʒ��ģ����ѯ��Ʒ��Ϣҳ��
	@Override
	public Integer getPageNumForAllByLikePname(String pName, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer count =dao.getForProductByPnameCount(pName);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("2.3��ø�����Ʒ��ģ����ѯ��Ʒ��Ϣҳ��ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//3.2��ѯ�۸����begin��Ʒ��Ϣ(��ҳ)
	@Override
	public List<Product> getAllByMaxPrice(Double beginPrice, Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//��ʼ���
			Integer end = (currentPage)*pageSize;//�������
			List<Product> pros = dao.selectProductByMaxForPrice(beginPrice, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("3.2��ѯ�۸����begin��Ʒ��Ϣ(��ҳ)ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//3.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��
	@Override
	public Integer getPageNumForAllByMaxPrice(Double beginPrice, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer count =dao.getProductByMaxForPriceCount(beginPrice);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("3.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//4.2��ѯ�۸�С��begin��Ʒ��Ϣ
	@Override
	public List<Product> getAllByMinPrice(Double endPrice, Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//��ʼ���
			Integer end = (currentPage)*pageSize;//�������
			List<Product> pros = dao.selectProductByMinForPrice(endPrice, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("4.2��ѯ�۸�С��begin��Ʒ��Ϣʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//4.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��
	@Override
	public Integer getPageNumForAllByMinPrice(Double endPrice, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			Integer count =dao.getProductByMinForPriceCount(endPrice);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("4.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}
	
}
