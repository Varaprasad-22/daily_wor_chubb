package Thread;

public class Worker extends Thread {
	@Override
	public void run() {
		System.out.println("Worker");
	}
}
