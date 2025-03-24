package com.epf.persistance.dao.impl;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class MapDAOImpl implements MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map get(int id_map) {
        return jdbcTemplate.queryForObject("SELECT * FROM map WHERE id_map = ?",
                new Object[]{id_map},
                (rs, rowNum) -> new Map(
                        rs.getInt("id_map"),
                        rs.getInt("ligne"),
                        rs.getInt("colonne"),
                        rs.getString("chemin_image")
                )
        );
    }

    @Override
    public List<Map> getAll() {
        return jdbcTemplate.query("SELECT * FROM map",
                (rs, rowNum) -> new Map(
                        rs.getInt("id_map"),
                        rs.getInt("ligne"),
                        rs.getInt("colonne"),
                        rs.getString("chemin_image")
                )
        );
    }

    @Override
    public void createMap(Map map) {
        jdbcTemplate.update("INSERT INTO map " +
                "(id_map," +
                "ligne," +
                "colonne," +
                "chemin_image)" +
                "VALUES (?, ?, ?, ?)",
                map.getId_map(),
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
                );
    }

    @Override
    public void updateMap(Map map) {
        jdbcTemplate.update("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                map.getId_map());
    }

    @Override
    public void deleteMap(Map map) {
        jdbcTemplate.update("DELETE FROM map WHERE id_map = ?", map.getId_map());
    }
}
