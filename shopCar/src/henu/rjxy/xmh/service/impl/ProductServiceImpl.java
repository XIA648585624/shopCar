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
	//获取所有商品信息
	@Override
	public List<Product> getAllProduct() {
		//获取连接
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectAllProduct();
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("查询所有商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}
	
	//根据商品名模糊查询商品信息
	@Override
	public List<Product> getAllByLikePname(String pName) {
		//获取连接
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByPname(pName);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("查询所有商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}
	
	//查询价格大于begin商品信息
	@Override
	public List<Product> getAllByMaxPrice(Double begin) {
		//获取连接
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByMaxForPrice(begin);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("查询所有商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}
	
	//查询价格小于begin商品信息
	@Override
	public List<Product> getAllByMinPrice(Double end) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			List<Product> pros = dao.selectProductByMinForPrice(end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("查询所有商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//分页查询
	@Override
	public List<Product> findProByPage(Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//开始序号
			Integer end = (currentPage)*pageSize;//结束序号
			List<Product> pros = dao.selectProductByPage(begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("查询所有商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//获取当前product的个数
	@Override
	public Integer getPageNum(Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer count =dao.selectProductCount();
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("获取信息个数失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//2.2根据商品名模糊查询商品信息（分页）
	@Override
	public List<Product> getAllByLikePname(String pName,Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//开始序号
			Integer end = (currentPage)*pageSize;//结束序号
			List<Product> pros = dao.selectProductByPname(pName, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("2.2根据商品名模糊查询商品信息（分页）失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//2.3获得根据商品名模糊查询商品信息页数
	@Override
	public Integer getPageNumForAllByLikePname(String pName, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer count =dao.getForProductByPnameCount(pName);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("2.3获得根据商品名模糊查询商品信息页数失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//3.2查询价格大于begin商品信息(分页)
	@Override
	public List<Product> getAllByMaxPrice(Double beginPrice, Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//开始序号
			Integer end = (currentPage)*pageSize;//结束序号
			List<Product> pros = dao.selectProductByMaxForPrice(beginPrice, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("3.2查询价格大于begin商品信息(分页)失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//3.3获得大于大于begin商品信息的页数
	@Override
	public Integer getPageNumForAllByMaxPrice(Double beginPrice, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer count =dao.getProductByMaxForPriceCount(beginPrice);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("3.3获得大于大于begin商品信息的页数失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//4.2查询价格小于begin商品信息
	@Override
	public List<Product> getAllByMinPrice(Double endPrice, Integer currentPage,Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer begin = (currentPage-1)*pageSize+1;//开始序号
			Integer end = (currentPage)*pageSize;//结束序号
			List<Product> pros = dao.selectProductByMinForPrice(endPrice, begin, end);
			conn.commit();
			return pros;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("4.2查询价格小于begin商品信息失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//4.3获得大于大于begin商品信息的页数
	@Override
	public Integer getPageNumForAllByMinPrice(Double endPrice, Integer pageSize) {
		Connection conn = JDBCUtil.getConnection();//获取连接
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			Integer count =dao.getProductByMinForPriceCount(endPrice);
			Integer pageNum = ((count/pageSize)*pageSize)==count?(count/pageSize):((count/pageSize)+1);
			conn.commit();
			return pageNum;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("4.3获得大于大于begin商品信息的页数失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}
	
}
