package com.epf.persistance.dao;

import com.epf.models.Plante;

import java.sql.SQLException;
import java.util.List;

public interface PlanteDAO {
    Plante get(int id_plante) throws SQLException;

    List<Plante> getAll() throws SQLException;

    void createPlante(Plante plante) throws SQLException;
    void updatePlante(Plante plante) throws SQLException;
    void deletePlante(int id) throws SQLException;
}
