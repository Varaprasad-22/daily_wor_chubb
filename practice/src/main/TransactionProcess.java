package moveOldFiles;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcess {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\hp\\Desktop\\transactions.txt";  
        List<Transaction> transactions = new ArrayList<>();
        double totalPaidByHDFC = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; 

                String[] data = line.split(",");
                if (data.length != 11) {
                    System.out.println("Invalid record skipped: " + line);
                    continue;
                }

                Transaction t = new Transaction(data);

                if (t.getTransferAmount() <= 0) {
                    System.out.println("Transfer failed for " + t.getSenderName() +
                            ": Invalid transfer amount " + t.getTransferAmount());
                    continue;
                }

                if (t.getSenderBalance() < t.getTransferAmount()) {
                    System.out.println(" Transfer failed for " + t.getSenderName() + ": Insufficient balance.");
                    continue;
                }

                double newBalance = t.getSenderBalance() - t.getTransferAmount();
                t.setSenderBalance(newBalance); 
                System.out.println(" Transfer successful from " + t.getSenderName() +" to " + t.getReceiverName() + " | Amount: " + t.getTransferAmount() + " | Type: " + t.getTransferType());

              
                if (t.getSenderIFSC().startsWith("HDFC")) {
                    totalPaidByHDFC += t.getTransferAmount();
                }
            }

            System.out.println("Total amount paid by HDFC Bank senders: " + totalPaidByHDFC);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
