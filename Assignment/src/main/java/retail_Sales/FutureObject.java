package retail_Sales;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FutureObject {
	public CompletableFuture<Double> exchange(){
		return CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
				System.out.println("Fetching exchange rate...");
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Its about Exchange Rete");
			return 34.5;
		});
	}
	public CompletableFuture<Double> disc(){
		return CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
				  System.out.println("Fetching discount rate...");
				}catch(Exception e){
					e.printStackTrace();
				}
			System.out.println("Discounts Avaliable");
			return 0.1;
		});
	}
	
	public void asyncCalls(List<Sales> salesList) {
		CompletableFuture<Double> exc=exchange();
		CompletableFuture<Double> disc=disc();
		
		//it is for combining and checking
		CompletableFuture<double[]> jointhread=exc.
				thenCombine(disc, (a,b)->{
					System.out.println("The Final Price");
					return new double[]{a,b};
				});
			
		jointhread.thenAccept(a -> {
	        double rate = a[0];
	        double discount = a[1];
	        
	        // Apply to sales data
	        salesList.forEach(sale -> {
	            double newTotal = (sale.getTotalPerCustomer() * rate) * (1 - discount);
	            System.out.println(sale.getCustId()+" value is "+newTotal);
	        });
	        
	        System.out.println("Updated all totals to INR with discount applied!");
	    });
		
		jointhread.join();
	}
}
