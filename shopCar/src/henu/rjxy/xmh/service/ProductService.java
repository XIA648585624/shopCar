package henu.rjxy.xmh.service;

import java.util.List;

import henu.rjxy.xmh.bean.Product;

public interface ProductService {
	//1.获得所有商品信息
	List<Product> getAllProduct();
	
	//2.1根据商品名模糊查询商品信息
	List<Product> getAllByLikePname(String pName);
	
	//2.2根据商品名模糊查询商品信息（分页）
	List<Product> getAllByLikePname(String pName,Integer currentPage,Integer pageSize);
	
	//2.3获得根据商品名模糊查询商品信息页数
	Integer getPageNumForAllByLikePname(String pName,Integer pageSize);
	
	//3.1查询价格大于begin商品信息
	List<Product> getAllByMaxPrice(Double begin);
	
	//3.2查询价格大于begin商品信息(分页)
	List<Product> getAllByMaxPrice(Double beginPrice,Integer currentPage,Integer pageSize);
	
	//3.3获得大于大于begin商品信息的页数
	Integer getPageNumForAllByMaxPrice(Double beginPrice,Integer pageSize);
	
	//4.1查询价格小于begin商品信息
	List<Product> getAllByMinPrice(Double end);
	
	//4.2查询价格小于begin商品信息
	List<Product> getAllByMinPrice(Double endPrice,Integer currentPage,Integer pageSize);
	
	//4.3获得大于大于begin商品信息的页数
	Integer getPageNumForAllByMinPrice(Double endPrice,Integer pageSize);
	
	//分页查询
	List<Product> findProByPage(Integer currentPage,Integer pageSize);
	
	//获取当前页面数
	Integer getPageNum(Integer pageSize);
}
