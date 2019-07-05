package db;

import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserDao {
    public UserDao() throws ClassNotFoundException, SQLException {

            Statement statement = DatabaseConnection.getStatement();

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");

            boolean exists = false;

            while (resultSet.next()) {
                if (resultSet.getString(1).equals("users")) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                statement.execute("CREATE TABLE users(email VARCHAR(50), password VARCHAR(256) NOT NULL, last_login TIMESTAMP NOT NULL, login_number INTEGER NOT NULL DEFAULT 0, CONSTRAINT users_pk PRIMARY KEY users(email))");
            }

    }

    public boolean isExists(String email) throws SQLException, ClassNotFoundException{
        try {
            Statement statement = DatabaseConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(email) FROM users WHERE email='" + email + "'");
            resultSet.next();
            if (resultSet.getInt(1) == 1) {
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println("Errored 2");
            return false;
        }
    }

    public void addUser(String email, String password) throws SQLException, ClassNotFoundException {

            Statement statement = DatabaseConnection.getStatement();
            statement.execute("INSERT INTO users(email, password) VALUES('" + email + "','" + password + "')");


    }

    public boolean checkFor(String email, String password) throws SQLException, ClassNotFoundException {
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE email='" + email +"'");
        if (resultSet.next()) {
            String retrievedPassword = resultSet.getString(1);
            if (retrievedPassword.equals(password)) {
                statement.execute("UPDATE users SET login_number = login_number + 1 WHERE email='" + email + "'");
                return true;
            }
        }
        return false;
    }

    public Date getLoginTimestamp(String email) throws SQLException, ClassNotFoundException {
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT last_login FROM users WHERE email='" + email + "'");
        Date result;
        if (resultSet.next()) {
            result = resultSet.getDate(1);
        } else {
            throw new SQLException();
        }
        return result;
    }

    public int getLoginNumber(String email) throws SQLException, ClassNotFoundException {
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT login_number FROM users WHERE email='" + email + "'");
        int result;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        } else {
            throw new SQLException();
        }
        return result;
    }
}
