package collections;
import collections.ArrayList;

import mediabiblioteket.Book;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import javax.lang.model.element.Element;

import java.nio.channels.ScatteringByteChannel;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTest<E> {




    ArrayList Testarray= new ArrayList();
    Object[] objs = new Object[]{3,4};

    @Test
    public void Add_AddedElementIs_SameAsStaticallyAddedElement() {

// Lägger in element i ArrayListen men ArrayList .add java-funktionen.
        ArrayList StaticlyAddArray= new ArrayList();

        StaticlyAddArray.add(null);
        StaticlyAddArray.add(null);
        StaticlyAddArray.add(null);
        StaticlyAddArray.add(null);
        StaticlyAddArray.add(null);
        StaticlyAddArray.add(objs);


// Lägger in element på rätt index med Add för att testa den metoden.
        Testarray.setSize(25);
        Testarray.add(5, objs);


        assertEquals(StaticlyAddArray.get(5), Testarray.get(5));


    }


    @Test
    public void Add__IndexIsBelowZero_IndexOutOfBoundsException() {
        try {
            Testarray.add(-5, objs);
        } catch (Exception e) {

            String test = e.toString();

            assertEquals("java.lang.IndexOutOfBoundsException", test);


        }
    }
    @Test

    public void Add__IndexIsAboveSize_IndexOutOfBoundsException() {
        try {
            Testarray.add(5, objs);
        }
        catch(Exception e) {

            String test = e.toString();

            assertEquals("java.lang.IndexOutOfBoundsException", test);



        }


    }

    @Test
    public void Add_TriggerGrow_ArraySizeIncreaseByOne() {
        ArrayList testgrow = new ArrayList();

        testgrow.setSize(2);
        testgrow.add(1, objs);


        assertEquals(3, testgrow.size());
    }





    @Test
    void getSize() {



    }

    @Test
    void setSize() {
    }

    @Test
    void sortByTitle() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void getElements() {
    }

    @Test
    void setElements() {
    }

    @Test
    void indexOfFirst() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }

    @Test
    void iterator() {
    }
}