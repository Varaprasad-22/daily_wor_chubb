package training;
import java.util.*;
public class Start {
	public void prime(){
		System.out.println("Java Project");
		int t1=0,t2=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Number");
		int x=sc.nextInt();
		
		for(int i=0;i<x;i++) {
			System.out.print(t1+" ");
			int y=t1;
			t1=t2;
			t2=t1+y;
		}
//		int y=sc.nextInt();
//		if(y==1) {
//			System.out.println("Not a Prime");
//		}
		for(int j=1;j<=500;j++) {
			if(j==1) {
				System.out.println("Not a Prime");
				continue;
			}

			int flag=0;
		for(int i=2;i*i<=j;i++) {
			if(j%i==0) {
//				System.out.println("Not a Prime");
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println(j);
		}
		}
		
		
	}
}