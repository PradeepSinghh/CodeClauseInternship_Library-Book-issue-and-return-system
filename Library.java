import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private DatabaseConnection databaseConnection;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.databaseConnection = new DatabaseConnection();
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book newBook = new Book();
        newBook.setBookID(bookID);
        newBook.setTitle(title);
        newBook.setAuthor(author);

        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    public void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID to remove: ");
        int bookID = scanner.nextInt();

        books.removeIf(book -> book.getBookID() == bookID);
        System.out.println("Book removed successfully.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book);
            }
        }
    }

    public void issueBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member ID: ");
        int memberID = scanner.nextInt();

        Member member = findMemberById(memberID);
        if (member == null) {
            System.out.println("Member not found. Please add the member first.");
            return;
        }

        System.out.print("Enter book ID to issue: ");
        int bookID = scanner.nextInt();

        Book bookToIssue = findBookById(bookID);
        if (bookToIssue == null || bookToIssue.isIssued()) {
            System.out.println("Book not available for issuing.");
            return;
        }

        member.issueBook(bookToIssue);
        System.out.println("Book issued successfully.");
    }

    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member ID: ");
        int memberID = scanner.nextInt();

        Member member = findMemberById(memberID);
        if (member == null) {
            System.out.println("Member not found. Please add the member first.");
            return;
        }

        System.out.print("Enter book ID to return: ");
        int bookID = scanner.nextInt();

        Book bookToReturn = findBookById(bookID);
        if (bookToReturn == null || !member.hasBook(bookToReturn)) {
            System.out.println("Book not issued to this member.");
            return;
        }

        member.returnBook(bookToReturn);
        System.out.println("Book returned successfully.");
    }

    public void displayIssuedBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member ID to display issued books: ");
        int memberID = scanner.nextInt();

        Member member = findMemberById(memberID);
        if (member == null) {
            System.out.println("Member not found. Please add the member first.");
            return;
        }

        List<Book> issuedBooks = member.getIssuedBooks();
        System.out.println("Issued Books for Member ID " + memberID + ":");
        for (Book book : issuedBooks) {
            System.out.println(book);
        }
    }

    private Member findMemberById(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return member;
            }
        }
        return null;
    }

    private Book findBookById(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }
}
