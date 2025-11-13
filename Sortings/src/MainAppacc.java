import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainAppacc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Account> a=new ArrayList<>();
		a.add(new Account("a", 102, "T123", "India", "IFSC001", 5000.0));
       a.add(new Account("e", 101, "T124", "India", "IFSC002", 7000.0));
        a.add(new Account("b", 104, "T125", "India", "IFSC003", 4000.0));
        a.add(new Account("c", 103, "T126", "India", "IFSC004", 9000.0));

        System.out.println(" Original List ");
        for (Account i : a) {
            System.out.print(i.getName()+" "+i.getAccNo()+" "+i.getBalance()+" "+i.getCountry()+" "+i.getIfscCode()+" "+i.getTransCode()+"\n");
        }
        Collections.sort(a);

        System.out.println("Sorted List");
        for (Account i : a) {
            System.out.print(i.getName()+" "+i.getAccNo()+" "+i.getBalance()+" "+i.getCountry()+" "+i.getIfscCode()+" "+i.getTransCode()+"\n");
        }
        Collections.sort(a,new AccountBaSort());

        System.out.println("Sorted List on Balance");
        for (Account i : a) {
            System.out.print(i.getName()+" "+i.getAccNo()+" "+i.getBalance()+" "+i.getCountry()+" "+i.getIfscCode()+" "+i.getTransCode()+"\n");
        }
        Collections.sort(a,new AccountNoSort());

        System.out.println("Sorted List on Account No");
        for (Account i : a) {
            System.out.print(i.getName()+" "+i.getAccNo()+" "+i.getBalance()+" "+i.getCountry()+" "+i.getIfscCode()+" "+i.getTransCode()+"\n");
        }
	}

}
