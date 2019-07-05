package com.company;

import java.sql.SQLException;
import java.util.List;

public interface IGenDAO<T> {
    T read(String key) throws SQLException;
    List<T> getAll() throws SQLException;
}
