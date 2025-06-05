import java.util.ArrayList;
import java.util.List;

public class Library {
    String name;
    List<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Method for students to implement: Add a book to the library
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        } else {
            System.out.println("Cannot add a null book to the library.");
        }
    }

    // Method for students to implement: Find a book by its title
    public Book findBookByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }
        for (Book book : this.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Placeholder
    }

    // Method for students to implement: Display all books in the library
    public void displayAllBooks() {
        if (this.books.isEmpty()) {
            System.out.println("The library has no books.");
        } else {
            System.out.println("\n--- Books in " + this.name + " ---");
            for (Book book : this.books) {
                book.displayBookInfo();
            }
            System.out.println("--- End of book list ---");
        }
    }
}
