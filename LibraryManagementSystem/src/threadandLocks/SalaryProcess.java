package threadandLocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class transfer{
	private String Sender;
	private String Receiver;
	private double amount;
	
	public transfer(String a,String b,double c) {
		this.amount=c;
		this.Receiver=b;
		this.Sender=a;
	}
	public void process() {
		System.out.println("Thread that found is"+Thread.currentThread().getName()+"sends "+ amount+" to "+ Sender);	
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Completeed");
	}
}

public class SalaryProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<transfer> a=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader("E:\\training_eclipse\\LibraryManagementSystem\\src\\threadandLocks\\transactions.txt"))){
			String line;
			while((line=br.readLine())!=null) {
				String data[]=line.split(",");
				if(data.length==3) {
					String sender = data[0].trim();
                    String receiver = data[1].trim();
                    double amount = Double.parseDouble(data[2].trim());
                    a.add(new transfer(sender, receiver, amount));
				}
			}
		}catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
		ExecutorService b=Executors.newFixedThreadPool(10);
		for(transfer i:a) {
			b.submit(()->i.process());
		}
		b.shutdown();	
		try {
            b.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}

}
