# Bhavanvir Rai
#### SENG 275 Assignment 2a

**Q1)**

Implementation:

    import java.util.ArrayList;
    import java.lang.String;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class AddMyAlphas {
        public static int Add(String numbers) throws NegativeIntegerException {
            Pattern integerPattern = Pattern.compile("-?\\d+");
            Matcher matcher = integerPattern.matcher(numbers);

            ArrayList<String> integerList = new ArrayList<>();

            int nums = 0;
            while(matcher.find()) {
                integerList.add(matcher.group());
                nums++;
            }

            if(nums == 0)
                return 0;

            int sum = 0;
            ArrayList<String> negatives = new ArrayList<>();

            for(String i: integerList)
                if(Integer.parseInt(i) < 0)
                    negatives.add(String.valueOf(Integer.valueOf(i)));
                else if(Integer.parseInt(i) < 1000)
                    sum += Integer.parseInt(i);

            if(negatives.size() > 0)
                throw new NegativeIntegerException("Negatives not allowed: " + String.join(", ", negatives));
            return sum;
        }
    }

    class NegativeIntegerException extends Exception{
        public NegativeIntegerException(String input){
            super(input);
        }
    }

Tests:

    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.ValueSource;

    import static org.junit.jupiter.api.Assertions.*;

    public class AddMyAlphasTest {
        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3", "6", "3, 3", "1, 1, 1, 1, 1, 1"})
        public void summationTest(String input) throws NegativeIntegerException {
            assertEquals(6, AddMyAlphas.Add(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1\n2", "//;\\n1;2"})
        public void delimiterTest(String input) throws NegativeIntegerException {
            assertEquals(3, AddMyAlphas.Add(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        public void emptyTest(String input) throws NegativeIntegerException {
            assertEquals(0, AddMyAlphas.Add(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1001, 2"})
        public void largeTest(String input) throws NegativeIntegerException {
            assertEquals(2, AddMyAlphas.Add(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"7, -1, -2", "-1, -2"})
        public void exceptionTest(String input){
            assertThrows(NegativeIntegerException.class, () -> AddMyAlphas.Add(input));
        }
    }



