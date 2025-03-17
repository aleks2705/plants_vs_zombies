package com.epf.persistance.dao.impl;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class PlanteDAOImpl implements PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Plante get(int id_plante) throws SQLException {
        return null;
    }

    @Override
    public List<Plante> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void createPlante(Plante plante) throws SQLException {

    }

    @Override
    public void updatePlante(Plante plante) throws SQLException {
        jdbcTemplate.update("UPDATE plante SET " +
                "nom = ?, " +
                "point_de_vie = ?, " +
                "attaque_par_seconde = ?," +
                "degat_attaque = ?," +
                "cout = ?," +
                "soleil_par_seconde = ?," +
                "effet = ?," +
                "chemin_image = ?"+
                "WHERE id_plante = ?",
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                plante.getId_plante());
    }

    @Override
    public void deletePlante(Plante plante) throws SQLException {
        jdbcTemplate.update("DELETE FROM plante WHERE id_plante = ?", plante.getId_plante());
    }
}
