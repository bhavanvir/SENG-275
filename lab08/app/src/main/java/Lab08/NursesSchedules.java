package Lab08;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NursesSchedules {
    public static void main(String[] args) throws IOException {
        for(int i = 1; i <= 6; i++)
            create_nurses_schedules(i);
    }

    public static int getRandomPatientNumber(){
        Random rand = new Random();
        return rand.nextInt((20 - 1) + 1) + 1;
    }

    public static int getRandomHourNumber(){
        Random rand = new Random();
        return rand.nextInt((7 - 1) + 1) + 1;
    }

    public static LocalTime getShiftedBlock(int nurseNumber){
        LocalTime shiftBlock1 = LocalTime.of(8, 0, 0);
        LocalTime shiftBlock2 = LocalTime.of(16, 0, 0);
        LocalTime shiftBlock3 = LocalTime.of(0, 0, 0);

        if(nurseNumber == 1 || nurseNumber == 2)
            return shiftBlock1.plusHours(getRandomHourNumber());
        else if(nurseNumber == 3 || nurseNumber == 4)
            return shiftBlock2.plusHours(getRandomHourNumber());
        else
            return shiftBlock3.plusHours(getRandomHourNumber());
    }

    public static void create_nurses_schedules(int nurseNumber) throws IOException {
        Patient p = new Patient();

        String[] names = {"Margaret Atwood", "Alexander Solzhenitsyn", "Charles Dickens", "Williams Wordsworth", "Homer", "Socrates"};
        String[] shifts = {"8 am to 4 pm", "4 pm to midnight",  "midnight to 8 am"};

        Nurse n = new Nurse();
        n.setName(names[nurseNumber - 1]);

        if(nurseNumber % 2 == 0) n.setShift(shifts[(nurseNumber / 2) - 1]);
        else n.setShift(shifts[((nurseNumber + 1) / 2) - 1]);

        String file = "n" + nurseNumber + "_schedule.txt";
        FileWriter myWriter = new FileWriter(file);
        myWriter.write(
                "Nurse Name: " + n.getName() + "\n" +
                "Schedule Shift: " + n.getShift() + "\n" +
                "Patient Number: " + getRandomPatientNumber() + "\n" +
                "Description Of Care: " + p.needs[getRandomPatientNumber() % 2] + ", and gave " + p.medications[getRandomPatientNumber() % 6] + "\n" +
                "Time Of Care: " + getShiftedBlock(nurseNumber).format(DateTimeFormatter.ofPattern("h a"))
        );
        myWriter.close();
    }
}