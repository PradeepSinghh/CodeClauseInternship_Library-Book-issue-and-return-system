import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public void issueBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            bookRepository.save(book);
        }
    }

    public void returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            bookRepository.save(book);
        }
    }
}
