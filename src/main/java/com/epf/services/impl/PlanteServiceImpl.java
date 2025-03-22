package com.epf.services.impl;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;
import com.epf.services.PlanteService;

import java.sql.SQLException;

public class PlanteServiceImpl implements PlanteService {
    private final PlanteDAO planteDAO;

    public PlanteServiceImpl(PlanteDAO planteDAO){
        this.planteDAO=planteDAO;
    }

    @Override
    public Plante getPlante(int id) {
        return planteDAO.get(id);
    }

    @Override
    public List<Plante> getAllPlantes() {
        return planteDAO.getAll();
    }

    @Override
    public void createPlante(Plante plante) {
        try{
            planteDAO.createPlante(plante);
        }catch (SQLException e){
            System.err.println("Erreur lors de la creation de la plante:" + e.getMessage());
        }
    }

    @Override
    public void updatePlante(Plante plante) {
        try{
            planteDAO.updatePlante(plante);
        }catch (SQLException e){
            System.err.println("Erreur lors de la MAJ de la plante:" + e.getMessage());
        }
    }

    @Override
    public void deletePlante(Plante plante) {
        try {
            planteDAO.deletePlante(plante);
        }catch (SQLException e){
            System.err.println("Erreur lors de la supression de la plante:" + e.getMessage());
        }
    }
}
