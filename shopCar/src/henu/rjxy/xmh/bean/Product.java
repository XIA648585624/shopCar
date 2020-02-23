package henu.rjxy.xmh.bean;

import java.io.Serializable;
/*名称                                      是否为空? 类型
		 ----------------------------------------- -------- ----------------------------
		 ID                                        NOT NULL NUMBER(7)
		 PRODUCTNAME                               NOT NULL VARCHAR2(20)
		 PRICE                                              NUMBER(7,2)
		 PICPATH                                            VARCHAR2(40)
		 DISCRIPTION                                        VARCHAR2(40)*/
public class Product implements Serializable{
	private Integer id;
	private String productname;
	private Double price;
	private String picpath;//图片路径
	private String discription;//商品描述
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id,String  productname, Double price, String picpath, String discription) {
		super();
		this.id = id;
		this.productname=productname;
		this.price = price;
		this.picpath = picpath;
		this.discription = discription;
	}
	
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((picpath == null) ? 0 : picpath.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (picpath == null) {
			if (other.picpath != null)
				return false;
		} else if (!picpath.equals(other.picpath))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product:["+id+","+productname+","+  price+","+picpath+","+ discription+"]";
	}
}
