package exercise;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
//
//	        System.out.print("Enter number of beneficiaries: ");
////	        int n = sc.nextInt();
//	        Benificiary beneficiaries =null;
	            System.out.print("Enter name of beneficiary #" );
	            String name = sc.nextLine();
//	            sc.nextLine();
	            System.out.print("Enter account number of " + name + ": ");
	            String acc = sc.nextLine();
//	            sc.nextLine();

Benificiary beneficiaries = new Benificiary(name, acc);
	        
	        double bankBalance = 5000;
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("\n===== Bank Transfer Menu =====");
	            System.out.println("1. UPI Payment");
	            System.out.println("3. Wallet Payment");
	            System.out.println("2. CreditCard Payment");
	            System.out.println("4. NetBanking Payment");
	            System.out.println("5. Exit");
	            System.out.print("Choose option: ");
	            int choice = sc.nextInt();
	            sc.nextLine();
	            if (choice == 5) {
	                exit = true;
	                System.out.println("Exiting... Thank you!");
	                continue;
	            }

	            System.out.print("Enter amount: ");
	            double amount = sc.nextDouble();
	            sc.nextLine(); // consume newline
	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter UPI PIN: ");
	                        String pin = sc.nextLine();
	                        Upi c = new Upi(amount, bankBalance, beneficiaries, pin);
	                        c.proccess();
	                        bankBalance=c.getBankBalance();
	                        break;
	                    case 2:
	                    	CreditCard c1 = new CreditCard(amount, bankBalance, beneficiaries);
	                    	c1.proccess();

	                        bankBalance=c1.getBankBalance();
	                        break;
	                    case 4:

	                        System.out.print("Enter password: ");
	                        String pasww = sc.nextLine();
	                    	NetBankingPayment c2 = new NetBankingPayment(amount, bankBalance, beneficiaries,pasww);
	                    	c2.proccess();

	                        bankBalance=c2.getBankBalance();
	                        break;
	                    default:
	                        System.out.println("Invalid option!");
	                        continue;
	                }

	            } catch (Exception e) {
	                System.out.println("TransactionFailedException: " + e.getMessage());
	            } 
	        }
	            
	}

}
