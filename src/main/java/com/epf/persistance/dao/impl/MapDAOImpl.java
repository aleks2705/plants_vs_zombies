package com.epf.persistance.dao.impl;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class MapDAOImpl implements MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        jdbcTemplate.update("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                map.getId_map());
    }

    @Override
    public void deleteMap(Map map) throws SQLException {
        jdbcTemplate.update("DELETE FROM map WHERE id_map = ?", map.getId_map());
    }
}
