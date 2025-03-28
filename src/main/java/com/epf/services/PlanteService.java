package com.epf.services;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;

import java.util.List;

public interface PlanteService {
    Plante getPlante(int id);
    List<Plante> getAllPlantes();
    void createPlante(Plante plante);
    void updatePlante(Plante plante);
    void deletePlante(int id);

}
