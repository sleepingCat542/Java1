package com.company;

import java.util.Date;

public class Letter {
    public int ID;
    public String Sender;
    public String Recipient;
    public String Message;
    public java.util.Date Date;

    @Override
    public String toString() {
        return "Letter{" +
                "ID=" + ID +
                ", Sender=" + Sender +
                ", Recipient=" + Recipient +
                ", Message='" + Message + '\'' +
                ", Date=" + Date +
                '}';
    }
}
