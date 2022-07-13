package Lab08;

public class Nurse{
    public String name;
    public String shift;

    public Nurse(){
        this.name = "N/A";
        this.shift = "N/A";
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getShift(){
        return shift;
    }

    public void setShift(String shift){
        this.shift = shift;
    }
}