package com.epf.persistance.dao;

import com.epf.models.Map;

import java.sql.SQLException;
import java.util.List;

public interface MapDAO {
    Map get(int id_map) throws SQLException;

    List<Map> getAll() throws SQLException;

    void createMap(Map map) throws SQLException;
    void updateMap(Map map) throws SQLException;
    void deleteMap(Map map) throws SQLException;
}
