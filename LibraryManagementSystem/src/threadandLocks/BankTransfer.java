package threadandLocks;

public class BankTransfer{
	private double balance=2000;
	public double getBalance() {
		return balance;
	}
	public synchronized boolean withdraw(double amount) {
		if(balance<amount) {
			System.out.println("Insufficient funds");
		}else if(balance>=amount) {
			try {
				Thread.sleep(1000);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			balance-=amount;
			System.out.println("The Balance after  "+Thread.currentThread().getName()+" is "+getBalance());
			return true;
		}
		return false;
	}
}
