package system;

// cause there may be librarian or professor so we need not write extra code in view of then so same id and name just extend
public class Person {
	private int id;
	private String name;
	public Person(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
