import java.util.Comparator;

public class AccountNoSort implements Comparator{
@Override
public int compare(Object o1,Object o2) {
	Account a1=(Account)o1;
	Account a2=(Account)o2;
	if(a1.getAccNo()>a2.getAccNo()) {
		return 1;
	}else if(a1.getAccNo()<a2.getAccNo()) {
		return -1;
	}
	return 0;
}
}
