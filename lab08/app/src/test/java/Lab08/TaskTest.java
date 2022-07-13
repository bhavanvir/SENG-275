package Lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task t;

    @BeforeEach
    public void init(){
        t = new Task();
        t.setPatientNumber(1);
        t.setCareProvided(t.needs[0]);
        t.setTimeOfCare("10 am");
        t.setAssignedNurseName("Margaret Atwood");
    }

    @Test
    public void getPatientNumberTest(){
        int result = t.getPatientNumber();
        assertEquals(1, result);
    }

    @Test
    public void getCareProvidedTest(){
        String result = t.getCareProvided();
        assertEquals(t.needs[0], result);
    }

    @Test
    public void getTimeOfCareTest(){
        String result = t.getTimeOfCare();
        assertEquals("10 am", result);
    }

    @Test
    public void getAssignedNurseNameTest(){
        String result = t.getAssignedNurseName();
        assertEquals("Margaret Atwood", result);
    }
}