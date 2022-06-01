package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // A sorted array - all at once
    @Test
    void sorted() {
        assertTrue(ArrayUtils.isSorted(new int[] {1,2,3,4}));
    }

    // Empty arrays are sorted
    @Test
    void emptyA(){
        int[] someArray = {};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }

    // Arrays of one element are sorted
    @Test
    void singleA(){
        int[] someArray = {1};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }

    // A partially sorted array
    @Test
    void partiallySorted(){
        int[] someArray = {1, 2, 4, 3, 5, 6};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertFalse(someArraySorted);
    }

    // A completely unsorted array
    @Test
    void unsortedA(){
        int[] someArray = {6, 2, 1, 5, 4, 3};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertFalse(someArraySorted);
    }

    // An array with duplicate values
    @Test
    void duplicateA(){
        int[] someArray = {1, 1, 2, 3, 4, 5};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }

}



