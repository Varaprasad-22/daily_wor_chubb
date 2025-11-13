package threadandLocks;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Order{
	private double amount;
	private int id;
	public Order(int a,double d) {
		this.amount=d;
		this.id=a;
	}
	
	public double getAmount() {
		return amount;
	}
	public int getId() {
		return id;
	}
}

public class ConcurrentQueue {

	private final static Queue<Order> a=new ConcurrentLinkedQueue<>();
	public static void  main(String[] args) {
		ExecutorService b=Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++) {
			b.submit(()->{
				 while(true) {
					 Order c=a.poll();
					 if(c!=null) {
						 process(c);
					 }try {
						 Thread.sleep(100);
					 }catch (InterruptedException e) {
                         Thread.currentThread().interrupt();
                         break;
                     }
				 }
			});
		}
		for(int i=1;i<1000;i++) {
			a.add(new Order(i,Math.random()*1000));
		}
		 try { Thread.sleep(5000); } catch (InterruptedException e) {}
	        b.shutdownNow();
	}
	
	private static void process(Order o) {
		System.out.println("the process for" +o.getAmount()+ "with id "+o.getId());
		try {
            // simulate payment and inventory update delay
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}
}
