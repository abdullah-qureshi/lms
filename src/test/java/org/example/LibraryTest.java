import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Effective Java", "Joshua Bloch", 2008);

        library.addBook(book);

        assertTrue(library.getBooksByAuthor("Joshua Bloch").contains(book), "Library should contain added book");
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Effective Java", "Joshua Bloch", 2008);

        library.addBook(book);
        library.removeBook(book);

        assertFalse(library.getBooksByAuthor("Joshua Bloch").contains(book), "Library should not contain removed book");
    }

    @Test
    public void testGetBooksByAuthor() {
        Library library = new Library();
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006);
        library.addBook(book1);
        library.addBook(book2);

        List<Book> booksByAuthor = library.getBooksByAuthor("Joshua Bloch");

        assertEquals(1, booksByAuthor.size(), "Library should return correct number of books by author");
        assertEquals(book1, booksByAuthor.get(0), "Returned book should match the added book by the author");
    }

    @Test
    public void testGetBooksByYear() {
        Library library = new Library();
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 2008);
        library.addBook(book1);
        library.addBook(book2);

        List<Book> booksByYear = library.getBooksByYear(2008);

        assertEquals(2, booksByYear.size(), "Library should return correct number of books published in the year");
        assertTrue(booksByYear.contains(book1) && booksByYear.contains(book2), "Library should return all books published in the specified year");
    }

    @Test
    public void testDisplayAllBooks() {
        Library library = new Library();
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006);
        library.addBook(book1);
        library.addBook(book2);

        library.displayAllBooks();
    }
}
