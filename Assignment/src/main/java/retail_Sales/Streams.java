package retail_Sales;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

	public static void generateReport(List<Sales> list) {
		System.out.println("Sales Report");
		
		double totalValue=list.stream()
				.mapToDouble(a->a.getTotalPerCustomer())
				.sum();
		//Or 
		double totalValue1=list.stream()
				.map(s->s.getTotalPerCustomer())
				.reduce(0, (a,b)->a+b);
		System.out.println("The Total Amount after the sales"+totalValue);
		
		//Total each quantity price
		Map<String,Integer> salesEach=list.stream().collect(Collectors.groupingBy(
				a->a.getCategory(),
				Collectors.summingInt(a->a.getQuantity())));
		System.out.println("Quantity Sold By Each Sale");
		salesEach.forEach((a,b)->System.out.println(a+" "+b));
		
		//averaging Sales
		Map<String,Double> pro=list.stream().collect(
				Collectors.groupingBy(
						a->a.getCategory(),
						Collectors.averagingInt(Sales::getPricePerUnit)));
		System.out.println("Average Price Per Sale");
		pro.forEach((a,b)->System.out.println(a+" "+b));
		
		System.out.println("Top 3 transactions");
		list.stream().sorted(Comparator.comparingInt(Sales::getTotalPerCustomer).reversed())
		.limit(3).forEach(s->System.out.println("Id is"+s.getTransId()+" Total value "+s.getTotalPerCustomer()));
	}
}


















