package system;

import java.util.ArrayList;
import java.util.List;

public class Members {
	private int id;
	private String name;
	private List<Book> borrowedBooks;
//	private List<Book> returnBok;
	public Members(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void borrowBook(Book b) {
		borrowedBooks.add(b);
		
	}
	public void returnBook(Book b) {
	 borrowedBooks.remove(b);
	}
	public List<Book> listOfBooks(){
		return borrowedBooks;
	}
	public void showBooks() {
		if(borrowedBooks.isEmpty()) {
			System.out.println("Zero Books Borrowed");
		}else {
			System.out.println("List Of Books");
			for(Book i:borrowedBooks) {
				System.out.println(i.getTitle());
			}
		}
	}
}
