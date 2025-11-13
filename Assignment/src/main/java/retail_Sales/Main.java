package retail_Sales;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	 private static final Logger logger = LogManager.getLogger(Main.class);

	
	public static void main(String[] args) {
        try {

		// TODO Auto-generated method stub
		String file="C:\\Users\\hp\\Downloads\\retail_sales_dataset.csv";
		String desti="resources/app.log";
		ReadCSV csvreader=new ReadCSV();
		List<Sales> salesList=csvreader.readFile(file);
		if(salesList.isEmpty()){
			System.out.println("Nodata");
			 logger.info("CSV file Empty ");

			return;
		}
		 logger.info("CSV file loaded successfully with " + salesList.size() + " records.");

		Streams data=new Streams();
		data.generateReport(salesList);
		logger.info("Reports generated successfully.");
		
		
		FutureObject asyncApi=new FutureObject();
		asyncApi.asyncCalls(salesList);
		logger.info("Async API simulation completed.");
		
	} catch (Exception e) {
        logger.error("Error during execution", e);
    }
	}

}
