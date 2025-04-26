package com.epf.services.impl;

import com.epf.models.Zombie;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.services.ZombieService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ZombieServiceImpl implements ZombieService {
    private final ZombieDAO zombieDAO;

    public ZombieServiceImpl(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public Zombie getZombie(int id) {
        try {
            return zombieDAO.get(id);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la get de la zombie:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Zombie> getAllZombies() {
        try {
            return zombieDAO.getAll();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la get de la zombie:" + e.getMessage());
        }
        return null;
    }

    @Override
    public void createZombie(Zombie zombie) {
        try {
            zombieDAO.createZombie(zombie);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la creation du zombie:" + e.getMessage());
        }
    }

    @Override
    public void updateZombie(Zombie zombie) {
        try {
            zombieDAO.updateZombie(zombie);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la MAJ du zombie:" + e.getMessage());
        }

    }

    @Override
    public void deleteZombie(int id) {
        try {
            zombieDAO.deleteZombie(id);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du zombie:" + e.getMessage());
        }
    }
}
