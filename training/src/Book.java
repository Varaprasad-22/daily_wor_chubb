
public class Book {
	private int BookId;
	private int BookPrice;
	private String BookName;
	private String BookCategory;
	private String AuthorName;
	
	public Book(int id,int price,String auth,String name,String cate) {
		this.BookId=id;
		this.BookCategory=cate;
		this.BookName=name;
		this.BookPrice=price;
		this.AuthorName=auth;
	}
	public int getPRice() {
		return BookPrice;
	}
	public int getBookId() {
		return BookId;
	}
	public String getBookName() {
		return BookName;
	}
	public String getBookCategory() {
		return BookCategory;
	}
	public String getAuthor() {
		return AuthorName;
	}
}
