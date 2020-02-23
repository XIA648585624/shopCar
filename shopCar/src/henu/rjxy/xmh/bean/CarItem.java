package henu.rjxy.xmh.bean;

public class CarItem {
	private Integer id;
	private String pname;
	private Double price;
	private String picpath;//图片路径
	private String discription;//商品描述
	private Integer pronum;//商品个数
	
	public CarItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarItem(Integer id,String pname, Double price, String picpath, String discription, Integer pronum) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.picpath = picpath;
		this.discription = discription;
		this.pronum = pronum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((picpath == null) ? 0 : picpath.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((pronum == null) ? 0 : pronum.hashCode());
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
		CarItem other = (CarItem) obj;
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
		if (pronum == null) {
			if (other.pronum != null)
				return false;
		} else if (!pronum.equals(other.pronum))
			return false;
		return true;
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

	public Integer getPronum() {
		return pronum;
	}

	public void setPronum(Integer pronum) {
		this.pronum = pronum;
	}
	
	@Override
	public String toString() {
		return "CarItem:[id:"+id+"pname:"+pname+",price:"+  price+",picpath:"+picpath+",discription:"+ discription+",pronum+:"+pronum+"]";
	}
}
