package mediabiblioteket;

import org.junit.jupiter.api.Test;


import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {
LibraryController LController = new LibraryController();
    JFrame frame = new JFrame();
    @Test
    void checkUserInput_goodInput_ExpectTrue() {
        assertTrue(LController.checkUserInput("test"));
    }
    @Test
    void checkUserInput_nullInput_expectFalse() {
        assertFalse(LController.checkUserInput(null));
    }
    @Test
    void checkUserInput_nothingString_expectFalse() {
        assertFalse(LController.checkUserInput(""));
    }
    @Test
    void checkUserInput_badInput_expectFalse() { assertFalse(LController.checkUserInput("%¤#¤¤")); }
    @Test
    void checkInputOnlyDigits_testLetters_expectFalse() { assertFalse(LController.checkInputOnlyDigits("test")); }
    @Test
    void checkInputOnlyDigits_validNumbers_ExpectTrue() { assertTrue(LController.checkInputOnlyDigits("123")); }
    @Test
    void checkInputOnlyDigits_toSmallNumber_ExpectFalse() { assertFalse( LController.checkInputOnlyDigits("-9130791238")); }
    @Test
    void checkInputOnlyDigits_toBigNumber_ExpectFalse() { assertFalse(LController.checkInputOnlyDigits("213079123801239931209")); }


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