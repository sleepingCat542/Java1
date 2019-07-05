package by.Khadasevich.Stream;
import by.Khadasevich.Student.Student;


import java.util.ArrayList;

public class RemedialStream
{
    ArrayList<Student> stream=new ArrayList<Student>();

    /*public void setMyPotok(ArrayList<Student> stream) {
        if (stream == null)
            throw new NullPointerException("Null pointer");
        this.stream = stream;
    }*/

    /*public ArrayList<Student> getMyPotok() {
        return stream;
    }*/

    public void AddStudent(Student pStud) {
        if (pStud == null)
            throw new NullPointerException("Null pointer");
        this.stream.add(pStud);
    }

    public Student GetStudByID(int id) {
        if(id>stream.size())
            throw new ArrayIndexOutOfBoundsException("Error in ID");
        return this.stream.get(id);
    }

    String name;

    public RemedialStream(String val) {
        this.name = val;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> GetMyPotok() {
        return this.stream;
    }
}
