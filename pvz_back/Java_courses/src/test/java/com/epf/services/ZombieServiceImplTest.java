package com.epf.services;

import com.epf.models.Zombie;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.services.impl.ZombieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZombieServiceImplTest {
    private ZombieDAO zombieDAO;
    private ZombieServiceImpl zombieService;

    @BeforeEach
    void setUp() {
        zombieDAO = Mockito.mock(ZombieDAO.class);
        zombieService = new ZombieServiceImpl(zombieDAO);
    }

    @Test
    void testGetZombie() throws SQLException {
        Zombie zombie = new Zombie(1, "Zombie 1", 100, BigDecimal.valueOf(1.0), 20, BigDecimal.valueOf(0.5), "webapp/images/zombie/zombie.png", 1);
        when(zombieDAO.get(1)).thenReturn(zombie);

        Zombie result = zombieService.getZombie(1);

        assertNotNull(result);
        assertEquals("Zombie 1", result.getNom());
        assertEquals(100, result.getPoint_de_vie());
        verify(zombieDAO, times(1)).get(1);
    }

    @Test
    void testGetAllZombies() throws SQLException {
        List<Zombie> zombies = Arrays.asList(
                new Zombie(1, "Zombie 1", 100, BigDecimal.valueOf(1.0), 20, BigDecimal.valueOf(0.5), "webapp/images/zombie/zombie.png", 1),
                new Zombie(2, "Zombie 2", 200, BigDecimal.valueOf(1.2), 30, BigDecimal.valueOf(0.4), "webapp/images/zombie/zombie.png", 1)
        );
        when(zombieDAO.getAll()).thenReturn(zombies);

        List<Zombie> result = zombieService.getAllZombies();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(zombieDAO, times(1)).getAll();
    }

    @Test
    void testCreateZombie() throws SQLException {
        Zombie zombie = new Zombie(3, "Zombie 3", 300, BigDecimal.valueOf(0.8), 40, BigDecimal.valueOf(0.3), "webapp/images/zombie/zombie.png", 2);
        zombieService.createZombie(zombie);

        verify(zombieDAO, times(1)).createZombie(zombie);
    }

    @Test
    void testDeleteZombie() throws SQLException {
        zombieService.deleteZombie(3);

        verify(zombieDAO, times(1)).deleteZombie(3);
    }
}
