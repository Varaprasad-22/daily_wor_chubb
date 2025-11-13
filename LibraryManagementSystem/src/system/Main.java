package system;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View Members");
            System.out.println("7. Exit");
            System.out.println("8. View Member's Borrowed Books");
            while(true) {

                System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Number of Copies: ");
                    int count = sc.nextInt();
                    library.addBook(new Book(id, title, author, count));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    library.addMember(new Members(mid, name));
                    break;

                case 3:
                    try {
                        System.out.print("Enter Member ID: ");
                        int memId = sc.nextInt();
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        library.borrowBook(memId, bookId);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Member ID: ");
                        int memIdR = sc.nextInt();
                        System.out.print("Enter Book ID: ");
                        int bookIdR = sc.nextInt();
                        library.returnBook(memIdR, bookIdR);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    library.showAllBooks();
                    break;

                case 6:
                    library.showAllMembers();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    return;
                case 8:
                	System.out.println("Enter Id");
                	int memId=sc.nextInt();
                	Members mem=library.findMem(memId);
                	if(mem!=null) {
                		mem.showBooks();
                	}else {
                		System.out.print("No member Exists");
                	}
                	break;
                default:
                    System.out.println("Invalid choice!");
            }
            }
        }
	}

}
