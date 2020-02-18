package mediabiblioteket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book mediaTestBook;

    @BeforeEach
    void setUp_KP() {
        mediaTestBook = new Book("Book", "Book Title", "111", 1900, "Author");
    }

    @Test
    void testGetAuthor_KP() {
        assertEquals("Author", mediaTestBook.getAuthor());
    }

    @Test
    void testSetAuthor_KP() {
        mediaTestBook.setAuthor("New Author");
        assertEquals("New Author", mediaTestBook.getAuthor());
    }

    @Test
    void testSetAuthorInvalidInput_KP(){
        mediaTestBook.setAuthor("");
        assertEquals("Author", mediaTestBook.getAuthor());
        mediaTestBook.setAuthor("12332");
        assertEquals("Author", mediaTestBook.getAuthor());
        mediaTestBook.setAuthor(null);
        assertEquals("Author", mediaTestBook.getAuthor());
        mediaTestBook.setAuthor("%#");
        assertEquals("Author", mediaTestBook.getAuthor());
    }

    //Test toString med test data från setUp methoden
    @Test
    void testToString_KP() {
        Assertions.assertEquals("Book - Free\n" +
                " - Book Title - 1900 - Author", mediaTestBook.toString());
        mediaTestBook.setBorrowed(true);
        Assertions.assertEquals("Book - Borrowed\n" +
                " - Book Title - 1900 - Author", mediaTestBook.toString());
    }

    //Test list info med test data från setUp methoden
    @Test
    void testListInfo_KP() {
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 1900\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Free\n" +
                "ID: 111\n", mediaTestBook.listInfo());

        mediaTestBook.setBorrowed(true);
        mediaTestBook.setThisMediaBorrower(new Borrower("Borrower","1111", "1111"));
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 1900\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Taken\n" +
                "Borrower: Borrower\n" +
                "ID: 111\n", mediaTestBook.listInfo());

    }

}
