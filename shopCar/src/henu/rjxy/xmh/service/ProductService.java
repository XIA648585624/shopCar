package henu.rjxy.xmh.service;

import java.util.List;

import henu.rjxy.xmh.bean.Product;

public interface ProductService {
	//1.���������Ʒ��Ϣ
	List<Product> getAllProduct();
	
	//2.1������Ʒ��ģ����ѯ��Ʒ��Ϣ
	List<Product> getAllByLikePname(String pName);
	
	//2.2������Ʒ��ģ����ѯ��Ʒ��Ϣ����ҳ��
	List<Product> getAllByLikePname(String pName,Integer currentPage,Integer pageSize);
	
	//2.3��ø�����Ʒ��ģ����ѯ��Ʒ��Ϣҳ��
	Integer getPageNumForAllByLikePname(String pName,Integer pageSize);
	
	//3.1��ѯ�۸����begin��Ʒ��Ϣ
	List<Product> getAllByMaxPrice(Double begin);
	
	//3.2��ѯ�۸����begin��Ʒ��Ϣ(��ҳ)
	List<Product> getAllByMaxPrice(Double beginPrice,Integer currentPage,Integer pageSize);
	
	//3.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��
	Integer getPageNumForAllByMaxPrice(Double beginPrice,Integer pageSize);
	
	//4.1��ѯ�۸�С��begin��Ʒ��Ϣ
	List<Product> getAllByMinPrice(Double end);
	
	//4.2��ѯ�۸�С��begin��Ʒ��Ϣ
	List<Product> getAllByMinPrice(Double endPrice,Integer currentPage,Integer pageSize);
	
	//4.3��ô��ڴ���begin��Ʒ��Ϣ��ҳ��
	Integer getPageNumForAllByMinPrice(Double endPrice,Integer pageSize);
	
	//��ҳ��ѯ
	List<Product> findProByPage(Integer currentPage,Integer pageSize);
	
	//��ȡ��ǰҳ����
	Integer getPageNum(Integer pageSize);
}
