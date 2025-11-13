package immutabliity;

import java.util.Comparator;

public class ComparatorSort implements Comparator{
public int compare(Object a1,Object a2) {
	Account a=(Account)a1;
	Account b=(Account)a2;
	for(int i=0;i<Math.min(a.Name().length(),b.Name().length());i++) {
		if(a.Name().charAt(i)!=b.Name().charAt(i)) {
			return a.Name().charAt(i)-b.Name().charAt(i);
		}
	}
	return a.Name().length()-b.Name().length();
}
}
