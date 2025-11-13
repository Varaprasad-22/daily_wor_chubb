package threadandLocks;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankTransfer a=new BankTransfer();
		Thread t1=new Thread(()->a.withdraw(100),"User1");
		Thread t2=new Thread(()->a.withdraw(200),"User2");
		t1.start();
		t2.start();
	}

}
