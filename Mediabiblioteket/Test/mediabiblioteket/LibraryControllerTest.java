package mediabiblioteket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {
LibraryController LController = new LibraryController();
    @Test
    void checkUserInput_GiltigInput_ExpectTrue() {
      boolean test=  LController.checkUserInput("test");


        assertEquals(true, test);
    }
    @Test
    void checkUserInput_OgiltigInput_ExpectFalse() {
        boolean test=  LController.checkUserInput("@££$€$€£€€${{${");


        assertEquals(false, test);
    }

    /*@Test
    void checkUserInput_OgiltigInput_ExpectException() {
        try{

        boolean test=  LController.checkUserInput("");

        }

        catch(Exception e) {

            String test = e.toString();

            assertEquals("hmm", test);
        }
    }*/


    @Test
    void checkInputOnlyDigits() {
       boolean test= LController.checkInputOnlyDigits("");
       assertEquals(false, test);

    }

    @Test
    void writeToFile() {
    }

    @Test
    void borrowMedia() {
    }

    @Test
    void returnMedia() {
    }

    @Test
    void checkIfBorrowerExist() {
    }

    @Test
    void sortMedia() {
    }

    @Test
    void getMedia() {
    }

    @Test
    void showSelectedMediaInfo() {
    }

    @Test
    void searchMediaAllByString() {
    }

    @Test
    void getMediaFromSearchResult() {
    }

    @Test
    void searchMediaTitleByString() {
    }

    @Test
    void getBorrower() {
    }

    @Test
    void loadBorrowedMedia() {
    }

    @Test
    void searchBorrowed() {
    }
}