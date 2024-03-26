package jdbc;

public class product {
	int prodId;
	String prodname;
	Double price;
	
	public product(int prodId,String prodname,Double price)
	{
		super();
		this.prodId=prodId;
		this.prodname=prodname;
		this.price=price;
		
	}
	public product() {
		super();
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
