package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDAO_People implements IGenDAO<People>{
    private final Connection connection;

    public MyDAO_People(Connection connection) {
        this.connection = connection;
    }

    @Override
    public People read(String key) throws SQLException {
        String sql = "SELECT * FROM People;";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        People p = InfoPeople(rs);
        return p;
    }

    @Override
    public List<People> getAll() throws SQLException {
        String sql = "SELECT * FROM People;";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<People> list = new ArrayList<>();
        while(rs.next()){
            People p = InfoPeople(rs);
            list.add(p);
        }
        return list;
    }

    private People InfoPeople(ResultSet rs) throws SQLException {
        People p = new People();
        p.ID = rs.getInt("ID");
        p.Name = rs.getString("Name");
        p.Bday = rs.getDate("Birthday");
        return p;
    }
}
