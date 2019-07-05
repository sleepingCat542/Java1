package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDAO_Letter implements IGenDAO<Letter>{
    private final Connection connection;

    MyDAO_Letter(Connection connection) {
        this.connection = connection;
    }

    void del() throws SQLException {
        for (int i=8;i<=12;i++){
            String sql = "delete from Letter where ID=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,i);
            stm.executeUpdate();
        }
    }

    People personWithMinMessageLen() throws SQLException {
        String sql = "SELECT * FROM letter;";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Letter> list = new ArrayList<>();
        while (rs.next()) {
            Letter l = GetInfo(rs);
            list.add(l);
        }
        int count = list.get(0).Message.length();
        for(Letter l : list)
        {
            if(l.Message.length() <= count)
                count = l.Message.length();
        }
        Letter res = new Letter();
        for(Letter l : list)
        {
            if(l.Message.length() == count)
                res = l;
        }

        String sql1 = "SELECT People.Name FROM Letter, People WHERE Letter.Sender=People.NAME AND Letter.Message='"+res.Message+"';";
        Statement stm1 = connection.createStatement();
        ResultSet rs1 = stm1.executeQuery(sql1);
        rs1.next();
        People people=new People();
        people.Name = rs1.getString("Name");
        return people;
    }

    People personWithMaxMessageLen() throws SQLException {
        String sql = "SELECT * FROM Letter;";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Letter> list = new ArrayList<>();
        while (rs.next()) {
            Letter l = GetInfo(rs);
            list.add(l);
        }
        int count = list.get(0).Message.length();
        for(Letter l : list)
        {
            if(l.Message.length() >= count)
                count = l.Message.length();
        }
        Letter res = new Letter();
        for(Letter l : list)
        {
            if(l.Message.length() == count)
                res = l;
        }

        String sql1 = "SELECT People.Name FROM Letter, People WHERE Letter.Sender=People.NAME AND Letter.Message='"+res.Message+"';";
        Statement stm1 = connection.createStatement();
        ResultSet rs1 = stm1.executeQuery(sql1);
        rs1.next();
        People people=new People();
        people.Name = rs1.getString("Name");
        return people;
    }

    List<String> infoAboutPeople() throws SQLException {
        int count = getCountOfPeople();
        int[] send = new int[count];
        int[] recieve = new int[count];
        for (int i =1, j=0; i<=count;i++,j++){
            String sql1 = "SELECT count(Letter.Message) from Letter, People WHERE Letter.Sender=People.NAME AND Letter.Sender=?;";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setInt(1,i);
            ResultSet rs1 = stm1.executeQuery();
            rs1.next();
            send[j]=rs1.getInt(1);

            String sql2 = "SELECT count(Message) from Letter WHERE Recipient="+i+";";
            Statement stm2 = connection.createStatement();
            ResultSet rs2 = stm2.executeQuery(sql2);
            rs2.next();
            recieve[j]=rs2.getInt(1);
        }
        String sql3 = "SELECT People.Name FROM Letter, People WHERE Letter.Sender=People.Name;";
        Statement stm1 = connection.createStatement();
        ResultSet rs1 = stm1.executeQuery(sql3);
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        while(rs1.next()){
            String str = "["+rs1.getString(1)+", send:"+ send[i]+", recieve:"+recieve[i]+"]\n";
            list.add(str);
            i++;
        }

        return list;
    }

    List<People> getPeopleWithTopic() throws SQLException {
        String sql = "SELECT People.ID, People.Name, People.Birthday FROM People, Letter WHERE Letter.Sender=People.Name AND Letter.Message='Привет';";
        return getPeople(sql);
    }

    List<People> getPeopleWithoutTopic() throws SQLException {
        String sql = "SELECT People.ID, People.Name, People.Birthday FROM People, Letter WHERE Letter.Sender=People.Name AND Letter.Message!='Привет';";
        return getPeople(sql);
    }

    void sendEveryone(String user, String message) throws SQLException {
        int count=getCountOfPeople();
        int k=count+1;

        String sql1 = "insert into Letter values("+k+", "+user+", "+"Андрей"+", '"+message+"', '2019-04-22');";
        String sql2 = "insert into Letter values("+k+1+", "+user+", "+"Марина"+", '"+message+"', '2019-04-22');";
        Statement stm1 = connection.createStatement();
        stm1.executeUpdate(sql1);
        stm1.executeUpdate(sql2);
    }



    void createError() throws SQLException {
        String sql1 = "insert into People values('h','i');";
        Statement stm1 = connection.createStatement();
        stm1.executeUpdate(sql1);
    }

    private int getCountOfPeople() throws SQLException {
        String sql = "SELECT count(*) from People";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return rs.getInt(1);
    }

    private List<People> getPeople(String sql) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<People> list = new ArrayList<>();
        while (rs.next()) {
            People p = new People();
            p.ID = rs.getInt(1);
            p.Name = rs.getString(2);
            p.Bday = rs.getDate(3);
            list.add(p);
        }
        return list;
    }

    @Override
    public Letter read(String key) throws SQLException {
        String sql = "SELECT * FROM Letter";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Letter l = GetInfo(rs);
        return l;
    }

    @Override
    public List<Letter> getAll() throws SQLException {
        String sql = "SELECT * FROM Letter;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Letter> list = new ArrayList<>();
        while (rs.next()) {
            Letter l = GetInfo(rs);
            list.add(l);
        }
        return list;
    }

    private Letter GetInfo(ResultSet rs) throws SQLException {
        Letter l = new Letter();
        l.ID = rs.getInt("ID");
        l.Sender = rs.getString("Sender");
        l.Recipient = rs.getString("Recipient");
        l.Message = rs.getString("Message");
        l.Date = rs.getDate("SDate");
        return l;
    }
}
