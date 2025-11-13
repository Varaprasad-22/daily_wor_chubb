package retail_Sales;

public class Sales {
	private int transId;
	private String date;
	private String CustId;
	private int Age;
	private String Gender;
	private int Quantity;
	private int pricePerUnit;
	private String productCategory;
	private int total;
	
	public Sales(int id,String date,String cstId,int age,int Quan,int perUnit,String Cate,int total,String gender) {
		this.transId=id;
		this.Age=age;
		this.CustId=cstId;
		this.date=date;
		this.Gender=gender;
		this.pricePerUnit=perUnit;
		this.total=total;
		this.productCategory=Cate;
		this.Quantity=Quan;
	}
	public String getGender() {
		return Gender;
	}
	public String getCustId() {
		return CustId;
	}
	public String getCategory() {
		return productCategory;
	}
	public int getAge() {
		return Age;
	}
	public String getDate() {
		return date;
	}
	public int getTransId() {
		return transId;
	}
	public int getTotalPerCustomer() {
		return total;
	}
	public int getPricePerUnit() {
		return pricePerUnit;
	}
	public int getQuantity() {
		return Quantity;
	}
}





