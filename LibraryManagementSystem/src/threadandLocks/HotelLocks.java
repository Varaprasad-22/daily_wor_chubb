package threadandLocks;

class variables{
	final Object room=new Object();
	final Object payment=new Object();
}
class user extends Thread{
	private variables var;
	public user(variables a,String name) {
		super(name);
		this.var=a;
	}
	@Override
	public void run() {
		synchronized(var.room) {
			System.out.println(getName() + " locked ROOM");
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized(var.payment) {
            	 System.out.println(getName() + " locked PAYMENT");
                 System.out.println(getName() + " booking successful!");
            }
		}
	}
}
public class HotelLocks {
	public static void main(String[]args) {
		variables a=new variables();
		user a1=new user(a,"User1");
		user a2=new user(a,"User2");
		a1.start();
		a2.start();
	}
}
