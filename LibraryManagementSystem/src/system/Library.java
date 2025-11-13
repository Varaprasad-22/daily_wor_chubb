package system;

import java.util.*;

public class Library {

	private List<Book> books;
	private List<Members> members;
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

	
	public void addBook(Book b) {
		if(books.size()!=0)
		for(Book i:books) {
			if(i.getId()==b.getId())
				books.remove(b);
		}
		
		books.add(b);
		System.out.println("Added Sucessfully");
	}
	
	public void addMember(Members b) {
		for(Members i:members) {
			if(i.getId()==b.getId()) {
				System.out.println("Already exists");
				return;}
		}
		
		members.add(b);
		System.out.println("Registered Sucessfully");
	}
	public void borrowBook(int memId,int bookId) throws MemberNotFoundException,BookNotFoundException,BookNotAvaliableException{
		
		Members mem=findMem(memId);
		Book boo=findBook(bookId);
		
		if(mem==null) {
			throw new MemberNotFoundException("Please Enter a Valid member or register again");
		}
		if(boo==null) {
			throw new BookNotFoundException("No Book Avaliable under the name of this");
		}
		if(!boo.isAvaliable()) {
			 throw new BookNotAvaliableException("No copies left for " + boo.getTitle());
		}
		boo.borrow();
		mem.borrowBook(boo);
        System.out.println(mem.getName() + " borrowed " + boo.getTitle());
	}
	
	public Members findMem(int id) {
		
		for(Members i:members) {
			if(i.getId()==id)
				return i;
		}
		return null;
	}
private Book findBook(int id) {
		
		for(Book i:books) {
			if(i.getId()==id)
				return i;
		}
		return null;
	}
public void returnBook(int memberId, int bookId) throws BookNotAvaliableException, MemberNotFoundException {

	Members member = findMem(memberId);
    Book book = findBookInMember(member,bookId);

    if (book == null) throw new BookNotAvaliableException("Book ID not found.");
    if (member == null) throw new MemberNotFoundException("Member ID not found.");

    book.returnCopy();
    member.returnBook(book);
    System.out.println(member.getName() + " returned " + book.getTitle());
}
private Book findBookInMember(Members member,int id) {
	
	for(Book i:member.listOfBooks()) {
		if(i.getId()==id)
			return i;
	}
	return null;
}

public void showAllBooks() {
	for(Book i:books) {
		System.out.println(i.getTitle());
	}
}

public void showAllMembers() {
    members.forEach(m -> System.out.println(m.getId() + " - " + m.getName()));
}

}
