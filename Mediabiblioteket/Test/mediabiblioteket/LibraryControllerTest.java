package mediabiblioteket;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryControllerTest {
    private LibraryController LController;
    private LibraryController MController;
    private JFrame frame = new JFrame();
    private Borrower borrower;
    private ArrayList<Media> testarray = new ArrayList();
    @BeforeEach
    void setUp(){
        LController = new LibraryController(false);
        MController = mock(LibraryController.class);
        doNothing().when(MController).showMessage("Incorrect characters only 0-9 are allowed");

        Book bok= new Book("test1", "test1", "4321", 9998, "test");

        LController.getAllMediaObjects().add(bok);
        Book bok2= new Book("test", "test", "1234", 1111, "test");

        LController.getAllMediaObjects().add(bok2);
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
        assertFalse(MController.checkInputOnlyDigits("test"));
    }

    @Test
    void checkInputOnlyDigits_validNumbers_ExpectTrue() { assertTrue(LController.checkInputOnlyDigits("123")); }
    @Test
    void checkInputOnlyDigits_toSmallNumber_ExpectFalse() { assertFalse( MController.checkInputOnlyDigits("-9130791238")); }
    @Test
    void checkInputOnlyDigits_toBigNumber_ExpectFalse() { assertFalse( MController.checkInputOnlyDigits("213079123801239931209")); }
    @Test
    void checkInputOnlyDigits_nullInput_expectFalse() {
        assertFalse(MController.checkInputOnlyDigits(null));
    }




    @Test
    void writeToFile_compareTestDataWithWrittenTestDataInFile_expectToBeSAme() {
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
    void borrowMedia_TestBookObjectBorrowedVariable_ExpectTrue_JL_NOT_FINISHED() {
        //Media test_borrowMedia = new Media("Bok", "boktitel", "123", 45);
        Book testbok = new Book("Bok","Boktitel", "BokID", 1920, "Hermann Hesse");
        Borrower testB= new Borrower("testnamn", "121212-1212", "0700900909");
        LController.setCurrentBorrower(testB);
        LController.borrowMedia(testbok);
        assertTrue(testbok.borrowed);
    }

    @Test
    void testCheckInputOnlyDigitsNew(){

    }
    @Test
    void returnMedia() {
        Borrower borrower = new Borrower("Testname", "TEstpersonalnumber", "TEstPhoneNumber");

        Book boken = new Book("TEsttype", "TestTitle", "TestID", 1977, "TestAuthor");
        LController.setCurrentBorrower(borrower);

        LController.borrowMedia(boken);


        LController.returnMedia(boken);

        assertFalse(boken.borrowed);
        assertNull(boken.getThisMediaBorrower());
    }

    @Test
    void checkIfBorrowerExist() {
    }

    @Test
    void sortMedia_JL() {
        String iDBeforeSort =  LController.getAllMediaObjects().get(0).objectID;
        LController.sortMedia();
        String iDAfterSort  = LController.getAllMediaObjects().get(1).objectID;
        assertEquals(iDBeforeSort, iDAfterSort);

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