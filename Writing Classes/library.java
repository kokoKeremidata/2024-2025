public class library {
    public static void main(String[] args) {
        // Task 4: Create two or more Book objects with different attributes.
        Book book1 = new Book("readable book", "writing author", 250);
        Book book2 = new Book("nonreadable book", "nonwriting author", 0);
        // Task 5: Call the displayDetails method for each object.
        book1.displayDetails();
        book2.displayDetails();
    }
}

// Define the Book class
class Book {
    // Task 1: Add three attributes: title, author, and numberOfPages.
    private String title;
    private String author;
    private int numPages;
    // Constructor
    public Book(String intitle, String inauthor, int innumPages) {
        // Task 2: Initialize the attributes inside this constructor.
        title = intitle;
        author = inauthor;
        numPages = innumPages;
    }

    // Task 3: Add a method displayDetails() to print the book's details (title, author, and numberOfPages).
    public void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numPages);
        System.out.println(" ");
    }
}
