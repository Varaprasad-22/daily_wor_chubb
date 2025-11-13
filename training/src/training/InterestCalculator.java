package training;
import java.util.*;
public class InterestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Type of car varient");
		String car=sc.nextLine();
		CarVarient cars=new CarVarient();
		
		System.out.println("Color");
		String color=sc.nextLine();
		
//		System.out.println("Loan Amount");
//		double loanAmount=sc.nextDouble();
		
		double a=cars.car(car);
		System.out.println("Enter down Payment Amount");
		double downPayment=sc.nextDouble();
		a-=downPayment;
		
		System.out.println("Enter Loan Interest");
		double b=sc.nextDouble();
		
		System.out.println("Enter Tenure Period 3 or 5");
		double c=sc.nextDouble();
		
		System.out.println("Color "+color);
		
		//simple interest
		SimpleInterest s=new SimpleInterest();
		double simpleInterest=s.si(a, b, c);
		
		System.out.println("Simple Interest "+Math.floor(simpleInterest*100.0)/100.0);
		
		CompoundInterest ci=new CompoundInterest();
		double totalAmount=ci.totalAmount(a, simpleInterest);
		
		//si amoun to be paid
		System.out.println("Total Amount to be paid "+Math.floor(totalAmount*100.0)/100.0);
		
		//si monthly emi
		double emi=totalAmount/(c*12.0);
		System.out.println("EMI per month "+Math.floor(emi*100.0)/100.0);
		
		//compound interest
		double res1[]=ci.ci(a, b, c);
		System.out.println("Compound Interest "+Math.floor(res1[1]*100.0)/100.0);
		
		//total amount ci
		System.out.println("Total Amount in Compound Interest "+Math.floor(res1[0]*100.0)/100.0);
		
		//emi permonth ci
		double ciemi=ci.totalCompoundEmi(a, b, c);
		System.out.println("EMI per month "+Math.floor(ciemi*100.0)/100.0);
		
	}

}
