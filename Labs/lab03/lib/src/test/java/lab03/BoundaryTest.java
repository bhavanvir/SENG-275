package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 15, 20})
    void isComfortable(int temperature){
        assertTrue(Boundary.isComfortable(temperature));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 0, 21})
    void isUncomfortable(int temperature){
        assertFalse(Boundary.isComfortable(temperature));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, -2})
    void oneElevator(int storeys){
        assertEquals(Boundary.elevatorsRequired(storeys), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 4, 3, 2})
    void twoElevators(int storeys){
        assertEquals(Boundary.elevatorsRequired(storeys), 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9})
    void threeElevators(int storeys){
        assertEquals(Boundary.elevatorsRequired(storeys), 2);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-100, 200})
    void invalidLetterGrade(double grade){
        assertThrows(IllegalArgumentException.class, () -> Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 25, 49})
    void gradeF(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "F"); }

    @ParameterizedTest
    @ValueSource(doubles = {51, 55, 59})
    void gradeD(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "D");
    }

    @ParameterizedTest
    @ValueSource(doubles = {61, 63, 64})
    void gradeC(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "C");
    }

    @ParameterizedTest
    @ValueSource(doubles = {65, 67, 69})
    void gradeCPlus(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "C+");
    }

    @ParameterizedTest
    @ValueSource(doubles = {70, 71, 72})
    void gradeBMinus(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "B-");
    }

    @ParameterizedTest
    @ValueSource(doubles = {74, 75, 76})
    void gradeB(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "B");
    }

    @ParameterizedTest
    @ValueSource(doubles = {78, 79})
    void gradeBPlus(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "B+");
    }

    @ParameterizedTest
    @ValueSource(doubles = {80, 82, 84})
    void gradeAMinus(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "A-");
    }

    @ParameterizedTest
    @ValueSource(doubles = {85, 87, 89})
    void gradeA(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "A");
    }

    @ParameterizedTest
    @ValueSource(doubles = {90, 95, 99})
    void gradeAPlus(double grade){
        assertEquals(Boundary.percentageToLetterGrade(grade), "A+");
    }

}