import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testEquals() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book3 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006);

        assertEquals(book1, book2, "Books with same title, author, and year are equal");
        assertNotEquals(book1, book3, "Books with different title or author are not equal");
    }

    @Test
    public void testToString() {
        Book book = new Book("Effective Java", "Joshua Bloch", 2008);
        String expected = "Title: Effective Java, Author: Joshua Bloch, Year: 2008";

        assertEquals(expected, book.toString(), "toString should return book details in correct format");
    }
}
