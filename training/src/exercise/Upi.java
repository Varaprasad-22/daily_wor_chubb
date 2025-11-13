package exercise;

public class Upi extends Payment {
	private String pin;
	public Upi(double amount, double BankBalance,Benificiary ben,String pin) {
		super(amount, BankBalance,ben);
		this.pin=pin;
		// TODO Auto-generated constructor stub
	}
	
	public void proccess() {
		try {
			validate();
			if(pin==null||pin.equals("1234")) {
				throw new Exception("InvalidCredentialsException: Incorrect UPI PIN.");
			}
			 System.out.println("UPI payment initiated to " + ben + "...");
	            double newBalance = FundTranfer.transfer(ammount, bankbalance);
	            System.out.println("UPI Payment successful. Remaining balance: " + newBalance);
			
		}catch(Exception e) {

            System.out.println("TransactionFailedException: " + e.getMessage());
		}
	}
	
}
