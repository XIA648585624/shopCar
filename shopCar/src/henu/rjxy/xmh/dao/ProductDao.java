package henu.rjxy.xmh.dao;

import java.util.List;

import henu.rjxy.xmh.bean.Product;

public interface ProductDao {
	//��ҳ��ѯ
	public List<Product> selectProductByPage(Integer begin,Integer end);
	
	//��ѯ����product��Ϣ
	public List<Product> selectAllProduct();
	
	//������Ʒ���Ʋ�ѯ
	public List<Product> selectProductByPname(String pName);
	
	//������Ʒ���Ʋ�ѯ����ҳ��
	public List<Product> selectProductByPname(String pName,Integer begin,Integer end);
	
	//��ȡ������Ʒ����ѯ����Ϣ����
	public Integer getForProductByPnameCount(String pName);
	
	//���ݴ��ڸü۸��ѯ
	public List<Product> selectProductByMaxForPrice(Double begin);
	
	//���ݴ��ڸü۸��ѯ(��ҳ)
	public List<Product> selectProductByMaxForPrice(Double beginPrice,Integer begin,Integer end);
	
	//��ȡ���ݴ��ڸü۸��ѯ(��ҳ)��Ϣ����
	public Integer getProductByMaxForPriceCount(Double beginPrice);
	
	//����С�ڸ������ѯ
	public List<Product> selectProductByMinForPrice(Double end);
	
	//����С�ڸ������ѯ(��ҳ)
	public List<Product> selectProductByMinForPrice(Double endPrice,Integer begin,Integer end);
	
	//��ȡ����С�ڸü۸��ѯ(��ҳ)��Ϣ����
	public Integer getProductByMinForPriceCount(Double endPrice);
	
	//��ѯ��ǰ��product��Ϣ����
	public Integer selectProductCount();
}
