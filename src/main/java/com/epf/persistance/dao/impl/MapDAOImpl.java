package com.epf.persistance.dao.impl;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;

import java.sql.SQLException;
import java.util.List;

public class MapDAOImpl implements MapDAO {
    @Override
    public Map get(int id_map) throws SQLException {
        return null;
    }

    @Override
    public List<Map> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void createMap(Map map) throws SQLException {

    }

    @Override
    public void updateMap(Map map) throws SQLException {

    }

    @Override
    public void deleteMap(Map map) throws SQLException {

    }
}
