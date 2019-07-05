package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection connection;
    public static Statement getStatement() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/";

            String dbName = "univer";
            String dbUser = "root";
            String dbPassword = "1111";

            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL + dbName, dbUser, dbPassword);
        }
        return connection.createStatement();
    }
}
