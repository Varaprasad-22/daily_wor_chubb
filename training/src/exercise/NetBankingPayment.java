package exercise;

public class NetBankingPayment extends Payment {

    private String password;

    public NetBankingPayment(double amount, double bankBalance, Benificiary beneficiary, String password) {
        super(amount, bankBalance, beneficiary);
        this.password = password;
    }

    @Override
    public void proccess() {
        try {
            validate();
            if (password == null) {
                throw new Exception("InvalidCredentialsException: Invalid NetBanking password.");
            }
            System.out.println("NetBanking payment initiated to " + ben + "...");
            double newBalance = FundTranfer.transfer(ammount, bankbalance);
            System.out.println("NetBanking payment successful. Remaining balance: " + newBalance);
        } catch (Exception e) {
            System.out.println("TransactionFailedException: " + e.getMessage());
        }
    }

   
}
