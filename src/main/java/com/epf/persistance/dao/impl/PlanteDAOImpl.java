package com.epf.persistance.dao.impl;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteDAOImpl implements PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Plante get(int id_plante) {
        return jdbcTemplate.queryForObject("SELECT * FROM plante WHERE id_plante = ?",
                new Object[] { id_plante },
                (rs, rowNum) -> new Plante(
                        rs.getInt("id_plante"),
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getBigDecimal("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("cout"),
                        rs.getBigDecimal("soleil_par_seconde"),
                        Plante.Effet.valueOf(rs.getString("effet")),
                        rs.getString("chemin_image")));
    }

    @Override
    public List<Plante> getAll() {
        return jdbcTemplate.query("SELECT * FROM plante",
                (rs, rowNum) -> {
                    String effetRaw = rs.getString("effet");
                    Plante.Effet effet = effetRaw != null
                            ? Plante.Effet.valueOf(effetRaw.toUpperCase().replace(" ", "_"))
                            : null;
                    return new Plante(
                            rs.getInt("id_plante"),
                            rs.getString("nom"),
                            rs.getInt("point_de_vie"),
                            rs.getBigDecimal("attaque_par_seconde"),
                            rs.getInt("degat_attaque"),
                            rs.getInt("cout"),
                            rs.getBigDecimal("soleil_par_seconde"),
                            effet,
                            rs.getString("chemin_image")
                    );
                });
    }


    @Override
    public void createPlante(Plante plante) {
        jdbcTemplate.update("INSERT INTO plante " +
                "(id_plante," +
                "nom," +
                "point_de_vie," +
                "attaque_par_seconde," +
                "degat_attaque," +
                "cout," +
                "soleil_par_seconde," +
                "effet," +
                "chemin_image)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)",
                plante.getId_plante(),
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image());
    }

    @Override
    public void updatePlante(Plante plante) {
        jdbcTemplate.update("UPDATE plante SET " +
                "nom = ?, " +
                "point_de_vie = ?, " +
                "attaque_par_seconde = ?," +
                "degat_attaque = ?," +
                "cout = ?," +
                "soleil_par_seconde = ?," +
                "effet = ?," +
                "chemin_image = ? " +
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
    public void deletePlante(int id) {
        jdbcTemplate.update("DELETE FROM plante WHERE id_plante = ?", id);
    }
}
