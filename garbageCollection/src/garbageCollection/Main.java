package garbageCollection;

public class Main {

	public static void main(String []args) {
		Worker a=new Worker();
		Thread t1=new Thread(a);
		t1.start();
	}
}
