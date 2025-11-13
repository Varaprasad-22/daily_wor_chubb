package training;

public class CompoundInterest {
	public double[] ci(double a,double b,double c) {
		
		double i=1+(b/100);
		
		double finalamount=a*(Math.pow(i,c));
		double compound=finalamount-a;
//		double emi=finalamount/(c*12.0);
		return new double[]{finalamount,compound};
	}
	public double totalAmount(double a,double b) {
		//principal+Simple interest;
		return a+b;
	}
	public double totalCompoundEmi(double a,double b,double c) {
		b=(b/100.0)/12.0;
		c=c*12.0;
		double i=Math.pow(1+b,c);
		double j=(b*i)/(i-1);
		return a*(j);
	}
}
