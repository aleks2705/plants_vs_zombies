package com.epf.persistance.dao;

import com.epf.models.Zombie;
import com.epf.models.Map;

import java.sql.SQLException;
import java.util.List;

public interface ZombieDAO {

    Zombie get(int id_zombie) throws SQLException; //Method to get zombie by ID

    List<Zombie> getAll() throws SQLException; //returns a list of all zombie obj in the db
    List<Zombie> getZombiesByMap(int id_map) throws SQLException; //fetch all zombies associated with a specific map

    void createZombie(Zombie zombie) throws SQLException;
    void updateZombie(Zombie zombie) throws SQLException;
    void deleteZombie(Zombie zombie) throws SQLException;
}
