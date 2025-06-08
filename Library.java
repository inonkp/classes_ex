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

    //  Add a book to the library
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        } else {
            System.out.println("Cannot add a null book to the library.");
        }
    }

    /**
     *  Method for students to implement: Find a book by its title
     *  Go over all books and return the book which has the same title as the given title
     *  Use the method below this one for an example of how to go over all books.
     * @param title
     * @return
     */
    public Book findBookByTitle(String title) {
        
        return null; // Placeholder
    }

    /**
     * Example method: shows how to iterate all books in the library.
     * Displays all books
     */
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
