# Bhavanvir Rai
#### SENG 275 Assignment 1b

Q1) 

    I1 = {1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300} (all inputs are valid)
    I2 = {x < 1 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300} (x is invalid, y is valid and z is valid)
    I3 = {x > 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300} (x is invalid, y is valid and z is valid)
    I4 = {1 ≤ x ≤ 300 and y < 1 and 1 ≤ z ≤ 300} (x is valid, y is invalid and z is valid)
    I5 = {1 ≤ x ≤ 300 and y > 300 and 1 ≤ z ≤ 300} (x is valid, y is invalid and z is valid)
    I6 = {1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z < 1} (x is valid, y is valid and z is invalid)
    I7 = {1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z > 300} (x is valid, y is valid and z is invalid)
    I8 = {x < 1 and y < 1 and 1 ≤ z ≤ 300} (x is invalid, y is invalid and z is valid)
    I9 = {x < 1 and y > 300 and 1 ≤ z ≤ 300} (x is invalid, y is invalid and z is valid)
    I10 = {x > 300 and y > 1 and 1 ≤ z ≤ 300} (x is invalid, y is invalid and z is valid)
    I11 = {x > 300 and y > 300 and 1 ≤ z ≤ 300} (x is invalid, y is invalid and z is valid)
    I12 = {x < 1 and 1 ≤ y ≤ 300 and z < 1} (x is invalid, y is invalid and z is invalid)
    I13 = {x < 1 and 1 ≤ y ≤ 300 and z > 300} (x is invalid, y is invalid and z is invalid)
    I14 = {x > 300 and 1 ≤ y ≤ 300 and z < 1} (x is invalid, y is invalid and z is invalid)
    I15 = {x > 300 and 1 ≤ y ≤ 300 and z 300} (x is invalid, y is invalid and z is invalid)
    I16 = {x < 1 and y < 1 and z < 1} (all inputs are invalid)
    
Q2) 

a)

    public class FizzBuzz {
        public static String compute(int n){
            String output;
            if(n % 3 == 0 && n % 5 != 0)
                output = "Fizz!";
            else if(n % 3 != 0 && n % 5 == 0)
                output = "Buzz!";
            else if(n % 3 == 0 && n % 5 == 0)
                output = "FizzBuzz";
            else
                output = n + "!";
            return output;
        }
    }


b) She can remove T2, as both T1 and T2 output the same result, which if "FizzBuzz"
c) Test suite minimzation can be used to determine redundant test cases

d)

    import org.junit.Assert;
    import org.junit.Test;
    
    public class FizzBuzzTest {
        FizzBuzz f = new FizzBuzz();
    
        @Test
        public void integerTest(){
            String expected = "4!";
            String actual = f.compute(4);
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void fizzTest(){
            String expected = "Fizz!";
            String actual = f.compute(3);
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void buzzTest(){
            String expected = "Buzz!";
            String actual = f.compute(5);
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void fizzbuzzTest(){
            String expected = "FizzBuzz";
            String actual = f.compute(15);
            Assert.assertEquals(actual, expected);
        }
    }
Q3)

a)

    TestCase01 = "MDCXLIV"
    TestCase02 = "CMXCIX"
    TestCase03 = "XLVIII"
    TestCase04 = "DCCLXXXII"
    TestCase05 = "LXIV"
    
b)

    import org.junit.Assert;
    import org.junit.Test;
    
    public class RomanNumeralTest {
        RomanNumeral r = new RomanNumeral();
    
        @Test
        public void TestCase01(){
            int expected = 1644;
            int actual = r.convert("MDCXLIV");
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void TestCase02(){
            int expected = 999;
            int actual = r.convert("CMXCIX");
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void TestCase03(){
            int expected = 48;
            int actual = r.convert("XLVIII");
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void TestCase04(){
            int expected = 782;
            int actual = r.convert("DCCLXXXII");
            Assert.assertEquals(actual, expected);
        }
    
        @Test
        public void TestCase05(){
            int expected = 64;
            int actual = r.convert("LXIV");
            Assert.assertEquals(actual, expected);
        }
    }


    

