package exercise;

public class CreditCard extends Payment {

//	public CreditCard(double amount, double BankBalance) {
//		super(amount, BankBalance);
//		// TODO Auto-generated constructor stub
//	}
	public CreditCard(double amount, double BankBalance, Benificiary beneficiary) {
        super(amount, BankBalance, beneficiary);
    }
	@Override
	public void proccess() {
		try {
		validate();
		System.out.println("Credit card transfer");
		double newBalance=FundTranfer.transfer(ammount, bankbalance);
		System.out.println(ben.getNo()+" "+ben.getName());
		System.out.println("Credit card pay");
        System.out.println("CreditCard payment successful. Remaining balance: " + newBalance);
		}catch(Exception e) {
			  System.out.println("TransactionFailedException: " + e.getMessage());
		}
	}
}
