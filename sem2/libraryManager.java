import java.util.Scanner;
public class libraryManager{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Book[] books = {
               new Book("Book1","Hajime Isayama",2009,null),
               new Book("Book2", "Gege Akutami",2018,null),
               new Book("Book3","Andy Weir",2021,null)
        };
        for(int i = 0; i >= 0; i++){
            System.out.println("------Library Management System------\n1. Display Library\n2. Borrow Book\n3. Return Book\n4. Exit");
            int choice = sc.nextInt();
            String title = "";
            switch(choice){
                case 1:
                    displayLibrary(books,sc);
                    break;
                case 2:
                    title = sc.nextLine();
                    borrowBook(books,sc);
                    break;
                case 3:
                    title = sc.nextLine();
                    returnBook(books,title,sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    public static void displayLibrary(Book[] books, Scanner sc){
        System.out.println("------Library Inventory------");
        for(int i = 0; i < books.length; i++){
            System.out.println(books[i].getDetails());
            System.out.println();
        }
    }
    public static void borrowBook(Book[] books, Scanner sc){
        System.out.println("Name of the book you'd like to borrow: ");
        String title = sc.nextLine();
        if(existBook(books,title)) {
            for (int i = 0; i < books.length; i++) {
                if (title.equalsIgnoreCase(books[i].getTitle())) {
                    if (books[i].getBorrowerName() == null) {
                        System.out.println("Enter your name: ");
                        String name = sc.nextLine();
                        books[i].borrowBook(name);
                        System.out.println(title + " borrowed by " + name + " successfully");
                    } else {
                        System.out.println("Book already borrowed");
                    }
                }
            }
        }
    }
    public static void returnBook(Book[] books, String searchTitle, Scanner sc){
        System.out.println("Name of the book you'd like to return: ");
        searchTitle = sc.nextLine();
        if(existBook(books,searchTitle)) {
            for (int i = 0; i < books.length; i++) {
                if (searchTitle.equalsIgnoreCase(books[i].getTitle())) {
                    if (books[i].getBorrowerName() != null) {
                        books[i].returnBook();
                        System.out.println("Book returned successfully");
                    } else {
                        System.out.println("Book isn't borrowed");
                    }
                }
            }
        }
    }
    public static boolean existBook(Book[] books, String title){
        boolean found = false;
        for(int i = 0; i < books.length; i++){
            if(title.equalsIgnoreCase(books[i].getTitle())){
                found = true;
            }
        }
        if(found == false){
            System.out.println("Book does not exist");
        }
        return found;
    }
    public static int findByTitle(Book[] books, String title){
        int index = 0;
        for(int i = 0; i < books.length; i++){
            if(books[i].getTitle().equalsIgnoreCase(title)){
                index = i+1;
            }
        }
        return index;
    }
}
class Book{
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName;
    public Book(String title, String author, int yearPublished, String borrowerName){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = borrowerName;
    }
    public String getDetails(){
        if(borrowerName == null){
            return "Title: " + title + "\nAuthor: " + author + "\nYear published: " + yearPublished + "\nBorrower name: Available";
        }else{
            return "Title: " + title + "\nAuthor: " + author + "\nYear published: " + yearPublished + "\nBorrower name: " + borrowerName;
        }
    }
    public void updateBookInfo(String newTitle, String newAuthor, int newYearPublished){
        title = newTitle;
        author = newAuthor;
        yearPublished = newYearPublished;
    }
    public void borrowBook(String borrowerName){
        this.borrowerName = borrowerName;
    }
    public void returnBook(){
        this.borrowerName = null;
    }
    public String getTitle(){
        return title;
    }
    public String getBorrowerName(){
        return borrowerName;
    }
}
