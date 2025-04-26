package com.epf.services;

import com.epf.models.Plante;
import java.util.List;

public interface PlanteService {
    Plante getPlante(int id);

    List<Plante> getAllPlantes();

    void createPlante(Plante plante);

    void updatePlante(Plante plante);

    void deletePlante(int id);

}
