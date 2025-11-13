package exercise;

public abstract class Payment {
	//abstract cause to keep some sort of code here it self .
	protected double ammount,bankbalance;
	protected Benificiary ben;
	public  Payment(double amount,double BankBalance) {
		this.ammount=amount;
		this.bankbalance=BankBalance;
	}
	public  Payment(double amount,double BankBalance,Benificiary den) {
		this.ammount=amount;
		this.ben=den;
		this.bankbalance=BankBalance;
	}
	public abstract void proccess();
	
	protected void validate() {
		if(ammount>bankbalance) {
			throw new IllegalArgumentException("Minimun balance below");
		}
		else if(ammount<=0) {
			throw new IllegalArgumentException("please enter Minimun balance / amount is below 0");
		} else if (ben == null ||ben.getName() == null||ben.getNo()==null||ben.getNo().length()==0) {
            throw new IllegalArgumentException("Beneficiary details missing.");
            
        }
	}
	 public double getBankBalance() {
	        return bankbalance;
	    }
	
}
