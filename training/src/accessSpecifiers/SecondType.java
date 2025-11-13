package accessSpecifiers;
import java.util.*;
public class SecondType extends FirstType {
	static void yes() {
		System.out.println("child");
	}
	void no() {
		System.out.print("no child");
	}
	void nonstatic() {
		System.out.print("Parent");
	}
//	protected void  display() {
//		System.out.print("child protected ");
//	}
//	public void  display() {
//		System.out.println("child public ");
//	}
//	public void  display() {
//		System.out.println("child public ");
//	}
}
