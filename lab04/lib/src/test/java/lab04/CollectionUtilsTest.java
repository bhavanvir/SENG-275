package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CollectionUtilsTest {
    @Test
    void differentSizesContains(){
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(1);
        coll1.add(2);

        Collection<Object> coll2 = new ArrayList<>();
        coll2.add(1);
        coll2.add(2);
        coll2.add(3);

        assertTrue(CollectionUtils.containsAny(coll1, coll2));
    }

    @Test
    void differentSizesDoesntContains(){
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(1);
        coll1.add(2);

        Collection<Object> coll2 = new ArrayList<>();
        coll2.add(3);
        coll2.add(4);
        coll2.add(5);

        assertFalse(CollectionUtils.containsAny(coll1, coll2));
    }

    @Test
    void sameSizesDoesntContains(){
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(1);
        coll1.add(2);
        coll1.add(3);

        Collection<Object> coll2 = new ArrayList<>();
        coll2.add(4);
        coll2.add(5);
        coll2.add(6);

        assertFalse(CollectionUtils.containsAny(coll1, coll2));
    }

    @Test
    void sameSizesContains(){
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(1);
        coll1.add(2);
        coll1.add(3);

        Collection<Object> coll2 = new ArrayList<>();
        coll2.add(1);
        coll2.add(2);
        coll2.add(3);

        assertTrue(CollectionUtils.containsAny(coll1, coll2));
    }
}