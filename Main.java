import java.util.List; // Required for Student class


public class Main {
  public static void main(String[] args) {
    // Setup
    Library cityLibrary = new Library("City Central Library");
    Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
    Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
    Book book3 = new Book("1984", "George Orwell", "9780451524935");

    Student student1 = new Student("S1001", "Alice Smith");
    Student student2 = new Student("S1002", "Bob Johnson");

    // Perform tests
    performInitialLibrarySetup(cityLibrary, book1, book2, book3);
    testBookFinding(cityLibrary);
    testStudentBasicBorrowingAndErrors(student1, cityLibrary, book1, book2);
    testAnotherStudentBorrowing(student2, cityLibrary, book3);
    testInterStudentBorrowingAndReturning(student1, student2, cityLibrary, book1, book3);
    finalLibraryCheck(cityLibrary);
  }

  private static void performInitialLibrarySetup(Library library, Book b1, Book b2, Book b3) {
    System.out.println("=== TEST SUITE: Initial Library Setup ===");
    // Students will implement addBook in Library.java
    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);
    // Students will implement displayAllBooks in Library.java
    library.displayAllBooks();
  }

  private static void testBookFinding(Library library) {
    System.out.println("\n=== TEST SUITE: Book Finding Logic ===");
    // Students will implement findBookByTitle in Library.java
    Book foundBook = library.findBookByTitle("1984");
    if (foundBook != null) {
        System.out.println("\nFound book:");
        // Students will implement displayBookInfo in Book.java
        foundBook.displayBookInfo();
    } else {
        System.out.println("\nBook with title '1984' not found.");
    }
     Book notFoundBook = library.findBookByTitle("Non Existent Book");
    if (notFoundBook == null) {
        System.out.println("\nCorrectly did not find 'Non Existent Book'.");
    } else {
        System.out.println("\nERROR: Found 'Non Existent Book'.");
        notFoundBook.displayBookInfo();
    }
  }

  private static void testStudentBasicBorrowingAndErrors(Student student, Library library, Book b1, Book b2) {
    System.out.println("\n=== TEST SUITE: Student Basic Borrowing and Error Cases (Student: " + student.name + ") ===");
    // Students will implement borrowBook in Student.java
    student.borrowBook(b1, library); // Student borrows The Great Gatsby
    student.borrowBook(b2, library); // Student borrows To Kill a Mockingbird

    // Attempt to borrow a non-existent book (not in library)
    System.out.println("\n" + student.name + " tries to borrow a non-existent book:");
    Book nonExistentBook = new Book("The Martian", "Andy Weir", "9780553418026"); // Not added to library
    student.borrowBook(nonExistentBook, library);

    // Attempt to borrow a book Alice already has
    System.out.println("\n" + student.name + " tries to borrow a book they already have (The Great Gatsby):");
    student.borrowBook(b1, library);

    // Students will implement displayBorrowedBooks in Student.java
    student.displayBorrowedBooks();
  }

  private static void testAnotherStudentBorrowing(Student student, Library library, Book b3) {
    System.out.println("\n=== TEST SUITE: Another Student Borrowing (Student: " + student.name + ") ===");
    // Bob borrows a book (1984)
    student.borrowBook(b3, library);
    // Students will implement displayBorrowedBooks in Student.java
    student.displayBorrowedBooks();
  }

  private static void testInterStudentBorrowingAndReturning(Student studentA, Student studentB, Library library, Book bookToReturn, Book bookToAttemptBorrow) {
    System.out.println("\n=== TEST SUITE: Inter-Student Borrowing, Returning, and Re-Borrowing ===");
    System.out.println("--- Testing scenario with Student " + studentA.name + " and Student " + studentB.name + " ---");
    // Student A tries to borrow a book Student B has
    System.out.println("\n" + studentA.name + " tries to borrow \"" + bookToAttemptBorrow.getTitle() + "\" (which " + studentB.name + " has):");
    studentA.borrowBook(bookToAttemptBorrow, library);

    // Student A returns a book
    System.out.println("\n" + studentA.name + " returns \"" + bookToReturn.getTitle() + "\":");
    studentA.returnBook(bookToReturn, library);
    studentA.displayBorrowedBooks();

    System.out.println("\nLibrary state after " + studentA.name + " returns \"" + bookToReturn.getTitle() + "\":");
    library.displayAllBooks(); // Show bookToReturn is available again

    // Student B tries to borrow the book Student A just returned
    System.out.println("\n" + studentB.name + " tries to borrow \"" + bookToReturn.getTitle() + "\" (which " + studentA.name + " returned):");
    studentB.borrowBook(bookToReturn, library);
    studentB.displayBorrowedBooks();
  }

  private static void finalLibraryCheck(Library library) {
    System.out.println("\n=== TEST SUITE: Final Library State Check ===");
    // Students will implement displayBookInfo in Book.java (indirectly via displayAllBooks and displayBorrowedBooks)
    System.out.println("\n--- Final Library State ---");
    library.displayAllBooks(); // To see if books are managed (optional advanced)
  }


}
