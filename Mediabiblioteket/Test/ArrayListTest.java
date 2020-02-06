import collections.ArrayList;

import mediabiblioteket.Book;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Element;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTest<E> {




ArrayList Testarray= new ArrayList();
Object[] objs = new Object[]{3,4};

    @Test
    public void Add_TestArrayAdding_AddedElementIsSameAsStaticallyAddedElement() {

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
}
