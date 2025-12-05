package garbageCollection;

public class Worker implements Runnable{
	public int add(int a,int b) {
		add(2,3);
		return a+b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		add(2,3);
	}
}
