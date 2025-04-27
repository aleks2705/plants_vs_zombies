package com.epf.services;

import com.epf.models.Plante;
import com.epf.persistance.dao.PlanteDAO;
import com.epf.services.impl.PlanteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlanteServiceImplTest {
    private PlanteDAO planteDAO;
    private PlanteServiceImpl planteService;

    @BeforeEach
    void setUp(){
        planteDAO = Mockito.mock(PlanteDAO.class); //creation DAO fictif
        planteService = new PlanteServiceImpl(planteDAO); //injection dans service
    }

    @Test
    void testGetPlante() throws SQLException{
        Plante plante = new Plante(1, "Tournesol", 100, BigDecimal.valueOf(1.0), 10, 50, BigDecimal.valueOf(0.1), Plante.Effet.NORMAL, "webapp/images/plante/tournesol.png");
        when(planteDAO.get(1)).thenReturn(plante);

        Plante result = planteService.getPlante(1);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());
        verify(planteDAO, times(1)).get(1);
    }


    @Test
    void testGetAllPlantes() throws SQLException {
        List<Plante> plantes = Arrays.asList(
                new Plante(1, "Tournesol", 100, BigDecimal.valueOf(1.0), 10, 50, BigDecimal.valueOf(0.1), Plante.Effet.NORMAL, "images/plante/tournesol.png"),
                new Plante(2, "Pisto-pois", 150, BigDecimal.valueOf(1.5), 20, 100, BigDecimal.valueOf(0.0), Plante.Effet.NORMAL, "images/plante/pistopois.png")
        );
        when(planteDAO.getAll()).thenReturn(plantes);
        List<Plante> result = planteService.getAllPlantes();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(planteDAO, times(1)).getAll();
    }

    @Test
    void testCreatePlante() throws SQLException {
        Plante plante = new Plante(3, "Cactus", 120, BigDecimal.valueOf(0.8), 15, 75, BigDecimal.valueOf(0.0), Plante.Effet.NORMAL, "images/plante/cactus.png");
        planteService.createPlante(plante);
        verify(planteDAO, times(1)).createPlante(plante);
    }

    @Test
    void testDeletePlante() throws SQLException {
        planteService.deletePlante(3);

        verify(planteDAO, times(1)).deletePlante(3);
    }


}