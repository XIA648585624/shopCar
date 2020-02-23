package henu.rjxy.xmh.dao;

import java.util.List;

import henu.rjxy.xmh.bean.Product;

public interface ProductDao {
	//分页查询
	public List<Product> selectProductByPage(Integer begin,Integer end);
	
	//查询所有product信息
	public List<Product> selectAllProduct();
	
	//根据商品名称查询
	public List<Product> selectProductByPname(String pName);
	
	//根据商品名称查询（分页）
	public List<Product> selectProductByPname(String pName,Integer begin,Integer end);
	
	//获取根据商品名查询的信息条数
	public Integer getForProductByPnameCount(String pName);
	
	//根据大于该价格查询
	public List<Product> selectProductByMaxForPrice(Double begin);
	
	//根据大于该价格查询(分页)
	public List<Product> selectProductByMaxForPrice(Double beginPrice,Integer begin,Integer end);
	
	//获取根据大于该价格查询(分页)信息条数
	public Integer getProductByMaxForPriceCount(Double beginPrice);
	
	//根据小于该区间查询
	public List<Product> selectProductByMinForPrice(Double end);
	
	//根据小于该区间查询(分页)
	public List<Product> selectProductByMinForPrice(Double endPrice,Integer begin,Integer end);
	
	//获取根据小于该价格查询(分页)信息条数
	public Integer getProductByMinForPriceCount(Double endPrice);
	
	//查询当前表product信息个数
	public Integer selectProductCount();
}
