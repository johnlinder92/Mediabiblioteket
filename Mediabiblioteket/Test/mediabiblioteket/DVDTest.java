package mediabiblioteket;

import collections.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DVDTest {

    private DVD mediaTestDVD;
    private LinkedList<String> actors;

    @BeforeEach
    void setUp_KP() {
        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaTestDVD = new DVD("DVD", "DVD Title", "112", 1900,  actors);
    }

    @Test
    void testSetAndGetActors_KP(){
        LinkedList<String> testActors = new LinkedList<>();
        testActors.add("Actor 1");
        testActors.add("Actor 2");
        testActors.add("Actor 3");
        int actorsList = mediaTestDVD.getActors().size();
        actors.add("Actor 3");
        mediaTestDVD.setActors(actors);
        Assertions.assertEquals(actorsList+1, mediaTestDVD.getActors().size());
        boolean same = false;
        int count = 0;
        for (int i = 0; i < mediaTestDVD.getActors().size(); i++ ){
            if (testActors.get(i).equals(mediaTestDVD.getActors().get(i)))
                count++;
        }

        if (count==mediaTestDVD.getActors().size())
            same = true;

        Assertions.assertTrue(same);
    }

    //Test toString med test data från setUp methoden
    @Test
    void testToString_KP(){
        Assertions.assertEquals("DVD - Free\n" +
                " - DVD Title - 1900 - Actor 1 - Actor 2", mediaTestDVD.toString());
        mediaTestDVD.setBorrowed(true);
        Assertions.assertEquals("DVD - Borrowed\n" +
                " - DVD Title - 1900 - Actor 1 - Actor 2", mediaTestDVD.toString());
    }

    //Test list info med test data från setUp methoden
    @Test
    void  testListInfo_KP(){
        Assertions.assertEquals("Title: DVD Title \n" +
                "Year: 1900\n" +
                "Actors: Actor 1 - Actor 2\n" +
                "Type: DVD\n" +
                "Free\n" +
                "ID: 112\n", mediaTestDVD.listInfo());

        mediaTestDVD.setBorrowed(true);
        mediaTestDVD.setThisMediaBorrower(new Borrower("Borrower","1111", "1111"));
        Assertions.assertEquals("Title: DVD Title \n" +
                "Year: 1900\n" +
                "Actors: Actor 1 - Actor 2\n" +
                "Type: DVD\n" +
                "Is Borrowed\n" +
                "Borrower: Borrower\n" +
                "ID: 112\n", mediaTestDVD.listInfo());

    }

}
