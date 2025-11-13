import java.util.Comparator;

public class AccountBaSort implements Comparator{
public int compare(Object o1,Object o2) {
	Account a1=(Account)o1;
	Account a2=(Account)o2;
	if(a1.getBalance()>a2.getBalance()) {
		return 1;
	}else if(a1.getBalance()<a2.getBalance()) {
		return -1;
	}
	return 0;
}
}
