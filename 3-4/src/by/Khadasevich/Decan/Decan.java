package by.Khadasevich.Decan;

import by.Khadasevich.Stream.RemedialStream;
import by.Khadasevich.Student.Student;

import java.util.Comparator;

public class Decan extends Creator {
    String name;

    private static Decan ourInstance;

    public static Decan getInstance() {
        if (ourInstance == null)
            ourInstance = new Decan();
        return ourInstance;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public RemedialStream FactoryMethod(String val) {
        return new RemedialStream(val);
    }


    public void CounntCourses(RemedialStream val) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int unknown = 0;

        for (int i = 1; i < val.GetMyPotok().size(); i++) {
            switch (val.GetStudByID(i).getCourse()) {
                case 1:
                    first++;
                    break;
                case 2:
                    second++;
                    break;
                case 3:
                    third++;
                    break;
                case 4:
                    fourth++;
                    break;
                default:
                    unknown++;
                    break;
            }
        }
        System.out.println("Первый курс: " + first);
        System.out.println("Второй курс: " + second);
        System.out.println("Третий курс: " + third);
        System.out.println("Четвёртый курс: " + fourth);
    }
    public void CreatePotokByCourse(RemedialStream potok, RemedialStream newPotok, int course) {
        if (potok == null || newPotok == null)
            throw new NullPointerException("Null pointer");
        for (int i = 0; i < potok.GetMyPotok().size(); i++) {
            if (potok.GetStudByID(i).getCourse() == course)
                newPotok.GetMyPotok().add(potok.GetStudByID(i));
        }
    }

    public void SortByName(RemedialStream val) {
        if (val == null)
            throw new NullPointerException("Null pointer");
        val.GetMyPotok().sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getSurname().compareTo(b.getSurname());
            }
        });
    }

    public void SortByMark(RemedialStream val) {
        if (val == null)
            throw new NullPointerException("Null pointer");
        val.GetMyPotok().sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return (int)(a.zch.getAver_mark() - b.zch.getAver_mark());
            }
        });
    }

}

