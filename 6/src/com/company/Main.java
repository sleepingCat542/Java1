package com.company;

import by.Khadasevich.Decan.Decan;
import by.Khadasevich.Stream.RemedialStream;
import by.Khadasevich.Student.Form.FormEnum;
import by.Khadasevich.Student.Form.SpecialityEnum;
import by.Khadasevich.Student.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = (Logger) Logger.getLogger(Main.class);


    public static void main(String[] args) {
        try {

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }
}
