package mediabiblioteket;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryControllerTest {
    private LibraryController LController;
    private JFrame frame = new JFrame();
    private Borrower testB;
    private Book testBok;

    @BeforeEach
    void setUp(){
        LController = mock(LibraryController.class);
        doNothing().when(LController).showMessage("Incorrect characters only 0-9 are allowed");
        testBok = new Book("Bok","Boktitel", "BokID", 1920, "Hermann Hesse");
        testB= new Borrower("testnamn", "121212-1212", "0700900909");

    }

    @Test
    void checkUserInput_goodInput_ExpectTrue() {
        assertTrue(LController.checkUserInput("1"));
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
    void checkInputOnlyDigits_testLetters_expectFalse() {
        assertFalse(LController.checkInputOnlyDigits("test"));
    }

    @Test
    void checkInputOnlyDigits_validNumbers_ExpectTrue() { assertTrue(LController.checkInputOnlyDigits("123")); }
    @Test
    void checkInputOnlyDigits_toSmallNumber_ExpectFalse() { assertFalse( LController.checkInputOnlyDigits("-9130791238")); }
    @Test
    void checkInputOnlyDigits_toBigNumber_ExpectFalse() { assertFalse(LController.checkInputOnlyDigits("213079123801239931209")); }
    @Test
    void checkInputOnlyDigits_nullInput_expectFalse() {
        assertFalse(LController.checkInputOnlyDigits(null));
    }




    @Test
    void test_writeToFile() {
        // Fyll på strukturen borrowed med data
        String testdata = "121212-1212;123456"; // Personnummer;MedieID
        LController.borrowed.add(testdata);
        // Skriv dessa data till fil
        LController.writeToFile();
        // Läs tillbaka filen. Efter loopen skall den sista posten ligga i theLine. Det är den vi vill titta närmare på
        String theLine = "";
        try {
            Scanner theScanner = new Scanner(new File("Mediabiblioteket/files/Utlanade.txt"));
            while (theScanner.hasNext()){
                theLine = theScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Jämför filens innehåll med det vi skickade till den
        assertEquals(testdata, theLine);
        // Ta bort inskriven testdata
        LController.borrowed.removeLast();
        LController.writeToFile();
    }

    @Test
    void borrowMedia() {
        //Media test_borrowMedia = new Media("Bok", "boktitel", "123", 45);
        LController.borrowMedia(testBok);
        assertTrue(testBok.borrowed);
    }

    @Test
    void testCheckInputOnlyDigitsNew(){

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