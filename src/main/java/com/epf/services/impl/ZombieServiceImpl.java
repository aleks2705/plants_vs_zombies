package com.epf.services.impl;

import com.epf.models.Zombie;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.services.PlanteService;
import com.epf.services.ZombieService;

import java.sql.SQLException;
import java.util.List;

public class ZombieServiceImpl implements ZombieService {
    private final ZombieDAO zombieDAO;

    public ZombieServiceImpl(ZombieDAO zombieDAO){
        this.zombieDAO = zombieDAO;
    }

    @Override
    public Zombie getZombie(int id) {
        return zombieDAO.get(id);
    }

    @Override
    public List<Zombie> getAllZombies() {
        return zombieDAO.getAll();
    }

    @Override
    public void createZombie(Zombie zombie) {
        try {
            zombieDAO.createZombie(zombie);
        }catch (SQLException e){
            System.err.println("Erreur lors de la creation du zombie:" + e.getMessage());
        }
    }

    @Override
    public void updateZombie(Zombie zombie) {
        try {
            zombieDAO.updateZombie(zombie);
        }catch (SQLException e){
            System.err.println("Erreur lors de la MAJ du zombie:" + e.getMessage());
        }

    }

    @Override
    public void deleteZombie(Zombie zombie) {
        try {
            zombieDAO.deleteZombie(zombie);
        }catch (SQLException e){
            System.err.println("Erreur lors de la suppression du zombie:" + e.getMessage());
        }

    }
}
