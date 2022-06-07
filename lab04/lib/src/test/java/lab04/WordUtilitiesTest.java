package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {
    @ParameterizedTest
    @MethodSource("generator")
    void swapCase(String description, final String str, final String expected){
        String result = WordUtilities.swapCase(str);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(Arguments.of("string is null", null, null),
                Arguments.of("string is empty", "", ""),
                Arguments.of("string contains only spaces", "  ", "  "),
                Arguments.of("combination of upper, lower and spaces", "CoMbInATION of LETtErs anD SpACES", "cOmBiNation OF letTeRS ANd sPaces"),
                Arguments.of("combination of upper and lower", "coMbinatiON", "COmBINATIon"),
                Arguments.of("only uppercase", "COMBINATION", "combination"),
                Arguments.of("only lowercase", "combination", "COMBINATION")
        );
    }

}