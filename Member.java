import java.util.List;

public class Member {
    private int memberID;
    private String name;
    private List<Book> issuedBooks;

    public Member(int memberID, String name, List<Book> issuedBooks) {
        this.memberID = memberID;
        this.name = name;
        this.issuedBooks = issuedBooks;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<Book> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void issueBook(Book book) {
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            issuedBooks.add(book);
            System.out.println("Book '" + book.getTitle() + "' issued to Member ID " + memberID + ".");
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    public void returnBook(Book book) {
        if (book != null && issuedBooks.contains(book)) {
            book.setIssued(false);
            issuedBooks.remove(book);
            System.out.println("Book '" + book.getTitle() + "' returned by Member ID " + memberID + ".");
        } else {
            System.out.println("Book cannot be returned.");
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Issued Books for Member ID " + memberID + ":");
        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            for (Book book : issuedBooks) {
                System.out.println(book);
            }
        }
    }
}
