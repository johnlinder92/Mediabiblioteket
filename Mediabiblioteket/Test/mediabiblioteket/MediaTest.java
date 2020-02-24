package mediabiblioteket;


import collections.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {

    private Media mediaTestBook;
    private Media mediaTestDVD;
    private LinkedList<String> actors;

    @BeforeEach
    void setUp_KP() {
        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaTestBook = new Book("Book", "Book Title", "111", 1900, "Author");
        mediaTestDVD = new DVD("DVD", "DVD Title", "112", 1900,  actors);
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
        assertEquals("111", mediaTestBook.getObjectID());
    }


    @Test
    void testSetObjectID_KP() {
        mediaTestBook.setObjectID("1");
        assertEquals("1", mediaTestBook.getObjectID());
    }

    @Test
    void testSetObjectIDWithInvalidInput(){
        mediaTestBook.setObjectID("Test ID");
        assertEquals("111", mediaTestBook.getObjectID());
        mediaTestBook.setObjectID("");
        assertEquals("111", mediaTestBook.getObjectID());
        mediaTestBook.setObjectID(null);
        assertEquals("111", mediaTestBook.getObjectID());
        mediaTestBook.setObjectID("%#");
        assertEquals("111", mediaTestBook.getObjectID());
    }


    @Test
    void testGetYear_KP() {
        assertEquals(1900, mediaTestBook.getYear());
    }

    @Test
    void testSetYear_KP() {
        mediaTestBook.setYear(1901);
        assertEquals(1901, mediaTestBook.getYear());
    }

    @Test
    void testSetYearInvalidInput_KP() {
        mediaTestBook.setYear(0);
        assertEquals(1901, mediaTestBook.getYear());
        mediaTestBook.setYear(111111111);
        assertEquals(1901, mediaTestBook.getYear());
    }


    @Test
    void testGetAndSetThisMediaBorrower_KP() {
        Borrower borrower = new Borrower("","","");
        mediaTestBook.setThisMediaBorrower(borrower);
        assertEquals(borrower, mediaTestBook.getThisMediaBorrower());
    }

    @Test
    void testIsBorrowedAndSetBorrowed_KP() {
        mediaTestBook.setBorrowed(true);
        assertTrue(mediaTestBook.isBorrowed());
        mediaTestBook.setBorrowed(false);
        assertFalse(mediaTestBook.isBorrowed());
        assertFalse(mediaTestDVD.isBorrowed());
    }


    //Behövs ej testas här, implementeras av subklasen
    @Test
    void testListInfo_KP() {
    }

    @Test
    void testCompareTo_KP() {
        Media mediaToCompare = new Book("Book", "Book Title", "111", 1900, "Author");
        assertEquals(0, mediaToCompare.compareTo(mediaTestBook));
        mediaToCompare.setObjectID("10");
        assertTrue(mediaToCompare.compareTo(mediaTestBook)<0);
        mediaToCompare.setObjectID("1000");
        assertTrue(mediaToCompare.compareTo(mediaTestBook)>0);
        Borrower borrower = new Borrower("","","");
        assertTrue(mediaToCompare.compareTo(borrower)<0);
    }

    @Test
    void testEquals_KP() {
        Media media = mediaTestBook;
        Borrower borrower = new Borrower("","","");
        assertTrue(mediaTestBook.equals(media));
        assertFalse(mediaTestBook.equals(mediaTestDVD));
        assertFalse(mediaTestBook.equals(borrower));
    }
}