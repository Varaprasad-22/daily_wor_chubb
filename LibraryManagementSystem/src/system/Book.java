package system;

public class Book {
	private int bookId;
	private String title;
	private String aauthor;
	private boolean Avaliable;
	private int count;
	
	public Book(int id,String title,String aauthor,int count) {
		this.aauthor=aauthor;
		this.bookId=id;
		this.count=count;
		this.title=title;
	}
	public int getId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public boolean isAvaliable() {
		return count>0;
	}
	  public void returnCopy() {
	        count++;
	    }
	public void borrow() throws BookNotFoundException{
		if(count<=0) {
			throw new BookNotFoundException("Books aren't avaliable");
		}
		count--;
	}
}

