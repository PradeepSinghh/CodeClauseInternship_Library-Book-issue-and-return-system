public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isIssued;

    // Constructors, getters, setters...

    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}
