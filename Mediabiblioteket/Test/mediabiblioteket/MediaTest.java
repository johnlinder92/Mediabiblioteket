package mediabiblioteket;


import collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MediaTest {

    private Media mediaTestBook;
    private Media mediaTestDVD;
    private LinkedList<String> actors;

    @BeforeEach
    void setUp_KP() {
        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaTestBook = new Book("Book", "Book Title", "Test ID Book", 1900, "Author");
        mediaTestDVD = new DVD("DVD", "DVD Title", "Test ID DVD", 1900,  actors);
    }

    @Test
    void testGetMediaType_KP() {
        assertEquals("Book", mediaTestBook.getMediaType());
        assertNotEquals("Book", mediaTestDVD.getMediaType());

    }

    @Test
    void testSetMediaType_KP() {
        mediaTestBook.setMediaType("New Book");
        assertEquals("New Book", mediaTestBook.getMediaType());
    }

    @Test
    void testSetMediaTypeInvalidInput_KP() {

        mediaTestBook.setMediaType("");
        assertEquals("Book", mediaTestBook.getMediaType());
        mediaTestBook.setMediaType("12332");
        assertEquals("Book", mediaTestBook.getMediaType());
        mediaTestBook.setMediaType(null);
        assertEquals("Book", mediaTestBook.getMediaType());
        mediaTestBook.setMediaType("%#");
        assertEquals("Book", mediaTestBook.getMediaType());
    }


    @Test
    void testGetTitle_KP() {
        assertEquals("Book Title", mediaTestBook.getTitle());
        assertNotEquals("Book Title", mediaTestDVD.getTitle());
    }

    @Test
    void testSetTitle_KP() {
        mediaTestBook.setTitle("New Title");
        assertEquals("New Title", mediaTestBook.getTitle());
    }
    @Test
    void testSetMediaTitleInvalidInput_KP() {

        mediaTestBook.setTitle("");
        assertEquals("Book", mediaTestBook.getTitle());
        mediaTestBook.setTitle("12332");
        assertEquals("Book", mediaTestBook.getTitle());
        mediaTestBook.setTitle(null);
        assertEquals("Book", mediaTestBook.getTitle());
        mediaTestBook.setTitle("%#");
        assertEquals("Book", mediaTestBook.getTitle());
    }

    @Test
    void testGetObjectID_KP() {
        assertNotEquals("Test ID Book", mediaTestDVD.getObjectID());
        assertEquals("Test ID Book", mediaTestBook.getObjectID());
    }


    @Test
    void setObjectID() {

    }

    @Test
    void getYear() {
    }

    @Test
    void setYear() {
    }

    @Test
    void getThisMediaBorrower() {
    }

    @Test
    void setThisMediaBorrower() {
    }

    @Test
    void isBorrowed() {
    }

    @Test
    void setBorrowed() {
    }

    @Test
    void listInfo() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void testEquals() {
    }
}