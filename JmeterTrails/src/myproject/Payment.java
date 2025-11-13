package myproject;

public class Payment {
	private String name;
	private double amount;
	public Payment(String a,double b) {
		this.name=a;
		this.amount=b;
	} public void showDetails() {
        System.out.println("Payment from " + name + " of " + amount);
    }
}
