package com.epf.persistance.dao.impl;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;

import java.sql.SQLException;
import java.util.List;

public class PlanteDAOImpl implements PlanteDAO {
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

    }

    @Override
    public void deletePlante(Plante plante) throws SQLException {

    }
}
