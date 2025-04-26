package com.epf.persistance.dao.impl;

import com.epf.models.Zombie;
import com.epf.persistance.dao.ZombieDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieDAOImpl implements ZombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Zombie get(int id_zombie) {
        return jdbcTemplate.queryForObject("SELECT * FROM zombie WHERE id_zombie = ?",
                new Object[] { id_zombie },
                (rs, rowNum) -> new Zombie(
                        rs.getInt("id_zombie"),
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getBigDecimal("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getBigDecimal("vitesse_de_deplacement"),
                        rs.getString("chemin_image"),
                        rs.getObject("id_map", Integer.class)));
    }

    @Override
    public List<Zombie> getAll() {
        /*
         * jdbcTemplate.query(SQL, RowMapper, args …) RowMapper func qui trans lignes
         * result SQL en un objet Java
         * args =valeurs pour remplacer les '?'
         */
        return jdbcTemplate.query("SELECT * FROM zombie",
                (rs, rowNum) -> new Zombie(
                        rs.getInt("id_zombie"),
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getBigDecimal("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getBigDecimal("vitesse_de_deplacement"),
                        rs.getString("chemin_image"),
                        rs.getObject("id_map", Integer.class) // getObject peut etre "null" prc id_map peut etre "0"
                ));
    }

    @Override
    public List<Zombie> getZombiesByMap(int id_map) {
        return jdbcTemplate.query("SELECT * FROM zombie WHERE id_map = ?",
                new Object[] { id_map }, // Parametre pour le ?, Spring JDBC veut toujours un tableau avec .query
                (rs, rowNum) -> new Zombie(
                        rs.getInt("id_zombie"),
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getBigDecimal("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getBigDecimal("vitesse_de_deplacement"),
                        rs.getString("chemin_image"),
                        rs.getObject("id_map", Integer.class)));
    }

    @Override
    public void createZombie(Zombie zombie) {
        jdbcTemplate.update("INSERT INTO zombie " +
                "(id_zombie," +
                "nom, " +
                "point_de_vie, " +
                "attaque_par_seconde, " +
                "degat_attaque, " +
                "vitesse_de_deplacement, " +
                "chemin_image, " +
                "id_map) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                zombie.getId_zombie(),
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map());
    }

    @Override
    public void updateZombie(Zombie zombie) {
        jdbcTemplate.update("UPDATE zombie SET " +
                "nom = ?, " +
                "point_de_vie = ?, " +
                "attaque_par_seconde = ?, " +
                "degat_attaque = ?, " +
                "vitesse_de_deplacement = ?, " +
                "chemin_image = ?, " +
                "id_map = ? " +
                "WHERE id_zombie = ?",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                zombie.getId_zombie());
    }

    @Override
    public void deleteZombie(int id) {
        jdbcTemplate.update("DELETE FROM zombie WHERE id_zombie = ?", id);
        /*
         * ? est un espace réservé. JDBC remplace auto ? par zombie.getId_zombie
         * JDBC empeche une injection en traitant l'entrée comme une valeur et non du
         * code SQL
         */
    }
}
