package by.Khadasevich.Student;

import by.Khadasevich.Student.Form.FormEnum;
import by.Khadasevich.Student.Form.SpecialityEnum;
import org.apache.log4j.Logger;

public class Student
{
    private static final Logger LOG =
            Logger.getLogger(Student.class);
    String surname;
    SpecialityEnum specialty;
    int course;
    FormEnum formOfEducation;
    public Zach zch;
    Double mark;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSpecialty(SpecialityEnum specialty) {
        this.specialty = specialty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setFormOfEducation(FormEnum formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getSurname() {
        return surname;
    }

    public SpecialityEnum getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public FormEnum getFormOfEducation() {
        return formOfEducation;
    }

    public Double getMark() {
        return mark;
    }



    public Student(String surname, SpecialityEnum specialty, int course, FormEnum formOfEducation, Double mark) {
        this.surname = surname;
        this.specialty = specialty;
        this.course = course;
        this.formOfEducation = formOfEducation;
        zch = new Zach(mark);
    }

    public void GoWalk() {
        System.out.println("Ушёл гулять");
    }


    public void MissLesson() {
        System.out.println("Прогулял");
    }


    public void PlayGames() {
        System.out.println("Играет");
    }

    public class Zach {
        Zach(double pAver_mark) {
            aver_mark = pAver_mark;
        }

        double aver_mark;

        public void setAver_mark(double aver_mark) {
            this.aver_mark = aver_mark;
        }

        public double getAver_mark() {
            return aver_mark;
        }
    }
}
