package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDAO implements IDAO{
    private final String URI = "jdbc:mysql://localhost:3306/KillMe";
    private final String USERNAME = "root";
    private final String PASSWORD = "1111";

    public MyDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI, USERNAME, PASSWORD );
    }

    @Override
    public IGenDAO<People> getPeopleDAO(Connection connection) {
        return new MyDAO_People(connection);
    }

    @Override
    public IGenDAO<Letter> getLetterDAO(Connection connection) {
        return new MyDAO_Letter(connection);
    }
}
