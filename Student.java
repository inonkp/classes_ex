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

    // Method for students to implement: Borrow a book from the library
    public void borrowBook(Book book, Library library) {
        if (book == null || library == null) {
            System.out.println("Invalid book or library.");
            return;
        }
        Book libraryBook = library.findBookByTitle(book.getTitle());
        if (libraryBook == null) {
            System.out.println("\"" + book.getTitle() + "\" not found in the library.");
        } else if (libraryBook.isBorrowed()) {
            System.out.println("\"" + book.getTitle() + "\" is already borrowed by " + libraryBook.getOwner().name + ".");
        } else if (this.borrowedBooks.contains(libraryBook)) {
            System.out.println(this.name + " has already borrowed \"" + book.getTitle() + "\"."); // Should ideally not happen if isBorrowed is checked first
        } else {
            this.borrowedBooks.add(libraryBook);
            libraryBook.setOwner(this); // Set this student as the owner
            System.out.println(this.name + " successfully borrowed \"" + book.getTitle() + "\".");
        }
    }

    // Method for students to implement: Return a book to the library
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
