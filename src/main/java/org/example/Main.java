import java.util.List;
import java.util.Scanner;

// Excercise 1 Junit
/*
   Testing the Main class is challenging because it's built to interact
   with users via the command line. They require simulating user input and capturing console output.
   Typically, unit tests aim to verify specific outcomes from a method but testing Main class
   would mean testing various combinations of user choices
 */
public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search books by author");
            System.out.println("4. Search books by year");
            System.out.println("5. Display all books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the year of publication: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(title, author, year);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter the title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    System.out.print("Enter the author of the book to remove: ");
                    String authorToRemove = scanner.nextLine();
                    System.out.print("Enter the year of the book to remove: ");
                    int yearToRemove = scanner.nextInt();
                    scanner.nextLine();

                    Book bookToRemove = new Book(titleToRemove, authorToRemove, yearToRemove);
                    library.removeBook(bookToRemove);
                    break;

                case 3:
                    System.out.print("Enter the author: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> booksByAuthor = library.getBooksByAuthor(searchAuthor);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found by " + searchAuthor);
                    } else {
                        System.out.println("Books by " + searchAuthor + ":");
                        for (Book b : booksByAuthor) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter the publication year: ");
                    int searchYear = scanner.nextInt();
                    scanner.nextLine();

                    List<Book> booksByYear = library.getBooksByYear(searchYear);
                    if (booksByYear.isEmpty()) {
                        System.out.println("No books found from the year " + searchYear);
                    } else {
                        System.out.println("Books from the year " + searchYear + ":");
                        for (Book b : booksByYear) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Books in the library:");
                    library.displayAllBooks();
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

