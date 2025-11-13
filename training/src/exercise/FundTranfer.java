package exercise;

public class FundTranfer {
	public static double transfer(double amount, double bankBalance) {
        
        bankBalance -= amount;
        
        return bankBalance;
    }
}
