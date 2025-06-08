import java.util.ArrayList;
import java.util.List;

public class Student {
    String studentId;
    String name;
    List<Book> borrowedBooks;

    // Constructor
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Borrow Book Mehod:
     * 1) find the book by its title
     * 1.1) If the book is not in the library, print a message and exit.
     * 2) if the book is borrowed:
     * 2.1) print the name of the borrower
     * 2.1) If you are the borrower, print another message to say you are the borrower
     * 3) If the book is not borrowed, add it to the library and set its owner to be you.
     * @param book
     * @param library
     */
    public void borrowBook(Book book, Library library) {
        
    }

    // Return a book to the library
    public void returnBook(Book book, Library library) {
        if (book == null || library == null) {
            System.out.println("Invalid book or library for return.");
            return;
        }
        if (this.borrowedBooks.remove(book)) {
            book.setOwner(null); // Clear the owner
            System.out.println(this.name + " successfully returned \"" + book.getTitle() + "\".");
        } else {
            System.out.println(this.name + " did not borrow \"" + book.getTitle() + "\".");
        }
    }

    // Method for students to implement: Display all books borrowed by the student
    public void displayBorrowedBooks() {
        if (this.borrowedBooks.isEmpty()) {
            System.out.println(this.name + " has not borrowed any books.");
        } else {
            System.out.println("\n--- Books borrowed by " + this.name + " ---");
            for (Book book : this.borrowedBooks) {
                book.displayBookInfo();
            }
            System.out.println("--- End of borrowed books ---");
        }
    }
}
