package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO {
    Connection getConnection() throws SQLException;
    IGenDAO<People> getPeopleDAO(Connection connection);
    IGenDAO<Letter> getLetterDAO(Connection connection);
}
