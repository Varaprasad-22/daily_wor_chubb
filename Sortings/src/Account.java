import java.util.Comparator;

public class Account implements Comparable<Account>{
	private String Name;
	private int accNo;
	private String transCode;
	private String Country;
	private String Ifsccode;
	private double balance;
	public Account(String a,int b,String c,String d,String e,double f) {
		this.Name=a;
		this.accNo=b;
		this.transCode=c;
		this.Country=d;
		this.Ifsccode=e;
		this.balance=f;
	}
	public String getName() {
        return Name;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getTransCode() {
        return transCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getIfscCode() {
        return Ifsccode;
    }

    public double getBalance() {
        return balance;}
	@Override
	public int compareTo(Account o) {
		return this.Name.compareTo(o.Name);
	}
}
