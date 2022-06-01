package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {
    @ParameterizedTest
    @CsvSource({"1279, 719", "0, 0", "50, 50", "450, 450"})
    void isInside(int width, int height){
        assertTrue(Specification.insideDisplayArea(width, height));
    }

    @ParameterizedTest
    @CsvSource({"1289, 729", "-1, -1", "1920, 1080", "1000, 1000"})
    void isOutside(int width, int height){
        assertFalse(Specification.insideDisplayArea(width, height));
    }

    @ParameterizedTest(name="input{0}, motorcycle{1}")
    @MethodSource("allValidMessages")
    void messageIsValid(String input, boolean motorcycle){
        assertTrue(Specification.messageIsValid(input, motorcycle));
    }

    private static Stream<Arguments> allValidMessages() {
        return Stream.of(
                Arguments.of("FREE-1", true),
                Arguments.of("ME2", true),
                Arguments.of("SUNNY-1", false),
                Arguments.of("PLT-4U", true));
    }

    @ParameterizedTest(name="input{0}, motorcycle{1}")
    @MethodSource("allInvalidMessages")
    void messageisInvalid(String input, boolean motorcycle){
        assertFalse(Specification.messageIsValid(input, motorcycle));
    }

    private static Stream<Arguments> allInvalidMessages() {
        return Stream.of(
                Arguments.of("7777777", false),
                Arguments.of("THISPLA", false),
                Arguments.of("666666", true ),
                Arguments.of("           ", true));
    }
}