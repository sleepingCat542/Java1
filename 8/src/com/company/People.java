package com.company;

import java.util.Date;

public class People {
    public int ID;
    public String Name;
    public Date Bday;

    @Override
    public String toString() {
        return "People{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Bday=" + Bday +
                '}';
    }
}
