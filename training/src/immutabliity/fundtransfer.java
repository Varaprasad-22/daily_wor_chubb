package immutabliity;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class fundtransfer {
	public static void main(String []args) {
		Account a=new Account("abc","123456",900000);
		Account b=new Account("efg","1234",1000);
		
		List<Account> c=transfer(a,b,100);
		System.out.println("from account "+c.get(0).bal());
		System.out.println("to account "+c.get(1).bal());
		Benificiary d=new Benificiary("Vivkey","1234567");
		var v=isEqual("Vivkey", d);
		System.out.println(v);
		c.stream().sorted((a2,b2)->Double.compare(a2.bal(),b2.bal())).forEach(System.out::println);
		
		Predicate<Account> filters=acc->acc.bal()>5000;
		c.stream().filter(filters).collect(Collectors.toList()).forEach(System.out::println);
		
		Function<Account,Account> map=acc-> new Account(acc.Name(),acc.no(), acc.bal() * 2);
		c.stream().map(map).collect(Collectors.toList()).forEach(System.out::println);
		
		c.stream().sorted(Comparator.comparing(acc->acc.no())).forEach(System.out::println);
		
		Predicate<Account> names=acc->acc.Name().startsWith("a");
		c.stream().filter(names).forEach(System.out::println);
		
		Consumer<Account> print=acc->System.out.println("Account name is "+acc.Name()+" no is "+acc.no()+"balance is "+acc.bal());
		c.stream().forEach(print);
		
		c.stream().sorted(Comparator.comparingDouble(acc->acc.bal()));
		
		c.stream().sorted(new ComparatorSort()).forEach(System.out::println);
	}
	public static boolean isEqual(String a,Benificiary b) {
		if(a.equals(b.name()))
			return true;
		return false;
	}
	public static List<Account> transfer(Account a,Account b,double amount){
		if(amount<=0) {
			System.out.println("Not possible");
			return List.of(a,b);
		}
		if(a.bal()<amount) {
			System.out.println("Insufficien funds");
			return List.of(a,b);
		}
		Account a1=new Account(a.Name(),a.no(),a.bal()-amount);
		Account b1=new Account(b.Name(),b.no(),b.bal()+amount);
		return List.of(a1,b1);
	}
}
