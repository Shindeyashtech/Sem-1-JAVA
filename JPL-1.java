// Write a java program to manage a library system with classes Representing Books and library members Each book as data field for its title AUTHOR , publication year ,and availability status .Member have data fields for Their name ,id ,and borrowed book themed include function to borrow and return Books, as well as to check the availability of book .create instance of books and Library members and simulate borrowing and returning book. display the Borrowing status of each book and member

import java.util.Scanner;
 class Book {
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
     public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;  
    }
     public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
     public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Sorry, this book is currently borrowed.");
        }}
     public void returnBook() {
        isAvailable = true;
    }
     public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", Available: " + (isAvailable ? "Yes" : "No"));
    }}
 class LibraryMember {
    private String name;
    private int id;
    private Book borrowedBook;
    public LibraryMember(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBook = null;  
    }
    public void borrowBook(Book book) {
        if (borrowedBook == null) {
            if (book.isAvailable()) {
                book.borrowBook();
                borrowedBook = book;
                System.out.println(name + " successfully borrowed the book: " + book.getTitle());
            } else {
                System.out.println("Book is not available for borrowing.");
            }
        } else {
            System.out.println(name + " has already borrowed a book. Please return it first.");
        }}
     public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            System.out.println(name + " returned the book: " + borrowedBook.getTitle());
            borrowedBook = null;
        } else {
            System.out.println(name + " has no borrowed books to return.");
        }}
     public void displayMemberStatus() {
        System.out.println("Member: " + name + " (ID: " + id + ")");
        if (borrowedBook != null) {
            System.out.println("Borrowed Book: " + borrowedBook.getTitle());
        } else {
            System.out.println("No book currently borrowed.");
        }}}
 public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Book book1 = new Book("The God of Small Things", "Arundhati Roy", 1997);
        Book book2 = new Book("Train to Pakistan", "Khushwant Singh", 1956);
        Book book3 = new Book("The White Tiger", "Aravind Adiga", 2008);
         LibraryMember member1 = new LibraryMember("Alice", 101);
        LibraryMember member2 = new LibraryMember("Bob", 102);
         int choice;
        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Display Book Details");
            System.out.println("2. Borrow Book (Member 1)");
            System.out.println("3. Borrow Book (Member 2)");
            System.out.println("4. Return Book (Member 1)");
            System.out.println("5. Return Book (Member 2)");
            System.out.println("6. Display Member Status");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                     book1.displayDetails();
                    book2.displayDetails();
                    book3.displayDetails();
                    break;
                case 2:
                     System.out.println("Choose a book to borrow (1: " + book1.getTitle() + ", 2: " + 			      book2.getTitle() + ", 3: " + book3.getTitle() + ")");
                    int bookChoice1 = scanner.nextInt();
                    if (bookChoice1 == 1) {
                        member1.borrowBook(book1);
                    } else if (bookChoice1 == 2) {
                        member1.borrowBook(book2);
                    } else if (bookChoice1 == 3) {
                        member1.borrowBook(book3);
                    }
                    break;
                case 3:
                     System.out.println("Choose a book to borrow (1: " + book1.getTitle() + ", 2: " + 	  	  	      book2.getTitle() + ", 3: " + book3.getTitle() + ")");
                    int bookChoice2 = scanner.nextInt();
                    if (bookChoice2 == 1) {
                        member2.borrowBook(book1);
                    } else if (bookChoice2 == 2) {
                        member2.borrowBook(book2);
                    } else if (bookChoice2 == 3) {
                        member2.borrowBook(book3);
                    }
                    break;
                case 4:
                     member1.returnBook();
                    break;
                case 5:
                     member2.returnBook();
                    break;
                case 6:         						                    	     		     	     member1.displayMemberStatus();
                    member2.displayMemberStatus();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
        scanner.close();
    }}


