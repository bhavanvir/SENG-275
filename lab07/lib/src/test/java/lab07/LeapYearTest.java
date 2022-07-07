
package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class LeapYearTest {
    @Property
    void validLeapYearWith400(@ForAll("leapYearWith400") int year){
        assertTrue(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYearWith400(){
        return Arbitraries.integers().filter(n -> n % 400 == 0).filter(n -> n > 0);
    }

    @Property
    void validLeapYearWithOnly4(@ForAll("leapYearWithOnly4") int year){
        assertTrue(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYearWithOnly4(){
        return Arbitraries.integers().filter(n -> n % 4 == 0).filter(n -> n % 400 != 0).filter(n -> n % 100 != 0).filter(n -> n > 0);
    }

    @Property
    void invalidLeapYearWith100And400(@ForAll("leapYearWith100And400") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYearWith100And400(){
        return Arbitraries.integers().filter(n -> n % 100 == 0).filter(n -> n % 400 != 0).filter(n -> n > 0);
    }

    @Property
    void invalidLeapYear(@ForAll("leapYear") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }

    @Provide Arbitrary<Integer> leapYear(){
        return Arbitraries.integers().filter(n -> n % 100 != 0).filter(n -> n % 400 != 0).filter(n -> n % 4 != 0).filter(n -> n > 0);
    }

    @Property
    void invalidLeapYearException(@ForAll("leapYearException") int year) {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYearException(){
        return Arbitraries.integers().filter(n -> n <= 0);
    }
}