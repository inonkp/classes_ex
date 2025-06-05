public class Book {
    String title;
    String author;
    String isbn;
    private Student owner;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.owner = null; // A new book is not owned initially
    }

    // Method for students to implement
    public void displayBookInfo() {
        System.out.print("Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.isbn);
        if (isBorrowed()) {
            System.out.println(" (Borrowed by: " + this.owner.name + ")"); // Assuming Student has a 'name' field accessible
        } else {
            System.out.println(" (Available)");
        }
    }

    // Getters (optional, but good practice)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student student) {
        this.owner = student;
    }

    public boolean isBorrowed() {
        return this.owner != null;
    }
}
