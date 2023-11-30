import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String displayBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "index";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        libraryService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/remove/{bookId}")
    public String removeBook(@PathVariable Long bookId) {
        libraryService.removeBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/issue/{bookId}")
    public String issueBook(@PathVariable Long bookId) {
        libraryService.issueBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/return/{bookId}")
    public String returnBook(@PathVariable Long bookId) {
        libraryService.returnBook(bookId);
        return "redirect:/";
    }
}
