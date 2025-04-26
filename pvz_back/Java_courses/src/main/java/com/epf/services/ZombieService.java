package com.epf.services;

import com.epf.models.Zombie;

import java.util.List;

public interface ZombieService {
    Zombie getZombie(int id);

    List<Zombie> getAllZombies();

    void createZombie(Zombie zombie);

    void updateZombie(Zombie zombie);

    void deleteZombie(int id);
}
