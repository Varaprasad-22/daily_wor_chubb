
public class Strings {
public static void main(String[]args) {
	String a="""
			abc %s
			bcd %d
			""".formatted("val",12);
	System.out.println(a);
}
}
