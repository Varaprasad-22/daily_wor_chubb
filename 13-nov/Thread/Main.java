package Thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Logger a= LogManager.getLogger(Main.class);
		Worker b=new Worker();
		b.start();
		a.info("Done logger");
	}

}
