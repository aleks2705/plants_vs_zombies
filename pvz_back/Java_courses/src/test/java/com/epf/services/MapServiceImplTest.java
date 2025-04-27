package com.epf.services;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;
import com.epf.services.impl.MapServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapServiceImplTest {
    private MapDAO mapDAO;
    private MapServiceImpl mapService;

    @BeforeEach
    void setUp() {
        mapDAO = Mockito.mock(MapDAO.class);
        mapService = new MapServiceImpl(mapDAO);
    }

    @Test
    void testGetMap() throws SQLException {
        Map map = new Map(1, 5, 9, "images/map/gazon.png");
        when(mapDAO.get(1)).thenReturn(map);

        Map result = mapService.getMap(1);

        assertNotNull(result);
        assertEquals(5, result.getLigne());
        assertEquals(9, result.getColonne());
        assertEquals("images/map/gazon.png", result.getChemin_image());
        verify(mapDAO, times(1)).get(1);
    }

    @Test
    void testGetAllMaps() throws SQLException {
        List<Map> maps = Arrays.asList(
                new Map(1, 5, 9, "images/map/gazon.png"),
                new Map(2, 6, 10, "images/map/gazon.png")
        );
        when(mapDAO.getAll()).thenReturn(maps);

        List<Map> result = mapService.getAllMaps();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(mapDAO, times(1)).getAll();
    }

    @Test
    void testCreateMap() throws SQLException {
        Map map = new Map(3, 7, 11, "images/map/gazon.png");
        mapService.createMap(map);

        verify(mapDAO, times(1)).createMap(map);
    }

    @Test
    void testDeleteMap() throws SQLException {
        mapService.deleteMap(3);

        verify(mapDAO, times(1)).deleteMap(3);
    }
}
