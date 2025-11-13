
public class Transaction {
    private String senderName;
    private String senderCountry;
    private String senderAccNo;
    private String senderIFSC;
    private double senderBalance;
    private double transferAmount;
    private String transferType;
    private String receiverName;
    private String receiverCountry;
    private String receiverAccNo;
    private String receiverIFSC;

    public Transaction(String[] data) {
        this.senderName = data[0];
        this.senderCountry = data[1];
        this.senderAccNo = data[2];
        this.senderIFSC = data[3];
        this.senderBalance = Double.parseDouble(data[4]);
        this.transferAmount = Double.parseDouble(data[5]);
        this.transferType = data[6];
        this.receiverName = data[7];
        this.receiverCountry = data[8];
        this.receiverAccNo = data[9];
        this.receiverIFSC = data[10];
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public String getSenderAccNo() {
        return senderAccNo;
    }

    public String getSenderIFSC() {
        return senderIFSC;
    }

    public double getSenderBalance() {
        return senderBalance;
    }
    
    public void setSenderBalance(double senderBalance) {
        this.senderBalance = senderBalance;
    }
    
    public double getTransferAmount() {
        return transferAmount;
    }

    public String getTransferType() {
        return transferType;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public String getReceiverAccNo() {
        return receiverAccNo;
    }

    public String getReceiverIFSC() {
        return receiverIFSC;
    }
}
