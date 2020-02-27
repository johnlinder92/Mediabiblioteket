package mediabiblioteket;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryControllerTest {
    private LibraryController LController;
    private GUI mockedGUI;
    private GUI gui;
    private LibraryController MController;
    private LibraryController Entill;
    private LibraryController johnController;
    private LibraryController ControllerwithGUI;
    private JFrame frame = new JFrame();
    private Borrower borrower;
    private String tempsearch = "";
    private ArrayList<Media> testarray = new ArrayList();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private LibraryController controllerNoArray;

    @BeforeEach
    void setUp(){

       System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));


        //    mockedGUI = mock(GUI.class) ;

        //     ControllerwithMockedGUI = new LibraryController(mockedGUI);
//        doNothing().when(mockedGUI).theController.searchMediaTitleByString(tempsearch);




        controllerNoArray = new LibraryController();
        johnController = new LibraryController(false);
        LController = new LibraryController(true);
        MController = mock(LibraryController.class);
        doNothing().when(MController).showMessage("Incorrect characters only 0-9 are allowed");

        Book bok= new Book("test1", "test1", "4321", 9998, "test");
        borrower= new Borrower("John", "19920703-3476", "0761412739");
        johnController.getAllMediaObjects().add(bok);
        Book bok2= new Book("test", "test", "1234", 1111, "test");

        johnController.getAllMediaObjects().add(bok2);
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
    void checkInputOnlyDigits_toBigNumber_ExpectFalse() { assertFalse( LController.checkInputOnlyDigits("213079123801239931209")); }
    @Test
    void checkInputOnlyDigits_nullInput_expectFalse() {
        assertFalse(LController.checkInputOnlyDigits(null));
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
            while (theScanner.hasNext()) {
                theLine = theScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Jämför filens innehåll med det vi skickade till den
        assertEquals(testdata,
                theLine);
        // Ta bort inskriven testdata
        LController.borrowed.removeLast();
        LController.writeToFile();
    }

    @Test
    void writeToFile_TriggerException_expectErrorMessageToBenull_JL() {
        controllerNoArray.writeToFile();
      assertTrue(outContent.toString().contains("null"));
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
    void returnMedia_JL() {
        Borrower borrower = new Borrower("Testname", "TEstpersonalnumber", "TEstPhoneNumber");

        Book boken = new Book("TEsttype", "TestTitle", "TestID", 1977, "TestAuthor");
        LController.setCurrentBorrower(borrower);

        LController.borrowMedia(boken);


        LController.returnMedia(boken);

        assertFalse(boken.borrowed);
        assertNull(boken.getThisMediaBorrower());
    }

    @Test
    void checkIfBorrowerExist_WithAnExistingBorrower_ExpectTrue_FH_JL() {
        assertTrue(LController.checkIfBorrowerExist("681102-9999"));

    }
    @Test
    void checkIfBorrowerExist_WithANonExistingBorrower_ExpectFalse_FH_JL() {
        assertFalse(LController.checkIfBorrowerExist("634544-3459"));

    }

    @Test
    void sortMedia_JL() {
        String iDBeforeSort =  johnController.getAllMediaObjects().get(0).objectID;
        johnController.sortMedia();
        String iDAfterSort  = johnController.getAllMediaObjects().get(1).objectID;
        assertEquals(iDBeforeSort, iDAfterSort);

    }

    @Test
    void getMedia_CompareWithTheCorrespondingMedia_expectThemToBeSame_FH_JL() {

        assertEquals( "DVD - Free\n - Crash - 2004 - Sandra Bullock - Don Cheadle - Matt Dillon - Jennifer Esposito - Brendan Fraser - Terrance Howard", LController.getMedia("211185").toString());
    }

    @Test
    void getMedia_CompareWithTheCorrespondingMediaLowestId_expectThemToBeSame_FH_JL() {

        assertEquals( "Bok - Free\n - Bock i Örtagård - 1933 - Nilsson", LController.getMedia("123938").toString());
    }


    // Krasen går det att göra detta test eller eftersom metoden skriver ut på GUI så är det svårt att verifiera?
    // hur skulle du göra test till denna metod?

   @Test
   void showSelectedMediaInfo() {
       gui = new GUI();
       ControllerwithGUI = new LibraryController(gui);
       ControllerwithGUI.searchMediaAllByString("Bok");
       ControllerwithGUI.showSelectedMediaInfo(   "Bok - Free\n - Historiens matematik - 1991 - Thompson");

       assertTrue(outContent.toString().contains("Historiens matematik"));


   }


    @Test
    void getMediaFromSearchResult_PrintOutAMedia_ExpectPrintToContainBookInfoFromTheMethod_JL() {
        tempsearch = "bok" ;
        gui = new GUI();
        ControllerwithGUI = new LibraryController(gui);

  ControllerwithGUI.searchMediaAllByString(tempsearch);
       Media testmedia =  ControllerwithGUI.getMediaFromSearchResult("Bok - Free\n - Historiens matematik - 1991 - Thompson");
        System.out.println(testmedia);
        assertTrue(outContent.toString().contains("Historiens matematik"));
    }



    @Test
    void searchMediaTitleByString_PrintOutSameAsTheSearchedMedia_Agenten_NE() {
        gui = new GUI();
        ControllerwithGUI = new LibraryController(gui);

       ControllerwithGUI.searchMediaTitleByString("Agenten");
        System.out.println(ControllerwithGUI.mediaSearchResults);
        assertTrue(outContent.toString().contains("Agenten"));
    }
    @Test
    void getBorrower() {
    }
    @Test
    void searchBorrowed() {
    }


    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}