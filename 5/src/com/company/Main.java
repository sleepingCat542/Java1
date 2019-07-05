package com.company;

import by.Khadasevich.Parser.SAX;
import by.Khadasevich.Parser.ValidatorXSD;
import by.Khadasevich.Student.Form.FormEnum;
import by.Khadasevich.Student.Form.SpecialityEnum;
import by.Khadasevich.Student.Student;
import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;


public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = (Logger) Logger.getLogger(Main.class);


    public static void main(String[] args) {

        Student nick   = new Student("Николай",  SpecialityEnum.ISIT, 1, FormEnum.ZAOCH, 8.2);
        Student alex   = new Student("Алексей",   SpecialityEnum.POIT,2, FormEnum.ZAOCH,  7.5);
        Student kate = new Student("Катя", SpecialityEnum.POIT,1, FormEnum.DAY,  6.2);

        try {
        ValidatorXSD val = new ValidatorXSD();
        val.valid();


        //SAX
        System.out.println("SAX");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAX sax = new SAX();
        parser.parse(new File("files/XML.xml"), sax);
        Student pers = sax.getResult();
        System.out.println(pers.getName() + "   " + pers.getSurname());


        //XMLtoHTML
        TransformerFactory xstf = TransformerFactory.newInstance();
        Transformer transformer = null;
        transformer=xstf.newTransformer(new StreamSource("files/XSL.xsl"));
        transformer.transform(new StreamSource("files/XMLtoHTML.xml"), new StreamResult("files/info.html"));


        //serialization
        FileOutputStream out = new FileOutputStream("files/serializ.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(out);
        xmlEncoder.writeObject(pers);
        xmlEncoder.close();


        //DEserialization
        System.out.println("DeSerializ");
        FileInputStream in = new FileInputStream("files/serializ.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(in);
        Student person = (Student) xmlDecoder.readObject();
        xmlDecoder.close();
        System.out.println(person.getName() + " " + person.getCourse());


        //json
        FileWriter out_JSON = new FileWriter("files/toJSON.json");

        Collection collection = new ArrayList<Student>();
        collection.add(person);
        collection.add(nick);
        Gson gson = new Gson();
        gson.toJson(collection, out_JSON);

        out_JSON.close();

        FileReader in_JSON = new FileReader("files/toJSON.json");
        //Student std = gson.fromJson(in_JSON, Student.class);
        in_JSON.close();


    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

        /*LOG.info("Starting program_______________________");
        LOG.info("Create Decan");
        Decan john = Decan.getInstance();
        LOG.info("Create first(Stream) by FactoryMethod");
        RemedialStream first = john.FactoryMethod("First");
        LOG.info("create and Add students to potok");

        Student dima   = new Student("Дмитрий", SpecialityEnum.POIT,2, FormEnum.DAY,  7.7);
        Student nick   = new Student("Николай",  SpecialityEnum.ISIT, 1, FormEnum.ZAOCH, 8.2);
        Student alex   = new Student("Алексей",   SpecialityEnum.POIT,2, FormEnum.ZAOCH,  7.5);
        Student kate = new Student("Катя", SpecialityEnum.POIT,1, FormEnum.DAY,  6.2);
        Student nikita = new Student("Никита", SpecialityEnum.ISIT,1, FormEnum.DAY,  9.3);
        Student sveta   = new Student("Светлана", SpecialityEnum.POIT,2, FormEnum.DAY,  6.7);
        Student andr   = new Student("Андрей",  SpecialityEnum.DEVI, 2, FormEnum.ZAOCH, 9.2);
        Student oleg   = new Student("Олег",   SpecialityEnum.POIT,2, FormEnum.ZAOCH,  7.9);
        Student maks = new Student("Максим", SpecialityEnum.POiBMS,3, FormEnum.EVENING,  8.2);
        Student angel = new Student("Ангелина", SpecialityEnum.ISIT,1, FormEnum.DAY,  9.5);

        first.AddStudent(nick);
        first.AddStudent(alex);
        first.AddStudent(dima);
        first.AddStudent(nikita);
        first.AddStudent(kate);
        first.AddStudent(sveta);
        first.AddStudent(andr);
        first.AddStudent(oleg);
        first.AddStudent(maks);
        first.AddStudent(angel);
        LOG.info("Counter of courses");
        john.CounntCourses(first);

        RemedialStream firstCourses = john.FactoryMethod("First Course");
        john.CreatePotokByCourse(first, firstCourses, 1);
        for (int i = 0; i < firstCourses.GetMyPotok().size(); i++) {
            System.out.println(i + ") " + firstCourses.GetStudByID(i).getSurname());
        }
        LOG.info("Sorting by name");
        System.out.println();
        for (int i = 0; i < first.GetMyPotok().size(); i++) {
            System.out.println(i + ") " + first.GetStudByID(i).getSurname());
        }
        john.SortByName(first);
        System.out.println();
        for (int i = 0; i < first.GetMyPotok().size(); i++) {
            System.out.println(i + ") " + first.GetStudByID(i).getSurname());
        }

        //firstCourses.GetStudByID(0).zch.getAver_mark();

        john.SortByMark(first);
        System.out.println();
        for (int i = 0; i < first.GetMyPotok().size(); i++) {
            System.out.println(i + ") " + first.GetStudByID(i).getSurname());
        }
        LOG.info("End Program___________");
    } catch (NullPointerException e) {
        System.out.println(e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
    }*/

    }
}
