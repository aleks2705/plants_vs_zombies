package com.epf.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.dto.ZombieDTO;
import com.epf.models.Zombie;
import com.epf.services.ZombieService;

@RestController
@RequestMapping("/zombies")
public class ZombieController {
    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping("/{id}")
    public ZombieDTO getzombie(@PathVariable int id) {
        Zombie zombie = zombieService.getZombie(id);
        return new ZombieDTO(zombie.getId_zombie(), zombie.getNom(), zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(), zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(), zombie.getId_map());
    }

    @GetMapping
    public List<ZombieDTO> getAllZombies() {
        return zombieService.getAllZombies().stream()
                .map(zombie -> new ZombieDTO(zombie.getId_zombie(), zombie.getNom(), zombie.getPoint_de_vie(),
                        zombie.getAttaque_par_seconde(), zombie.getDegat_attaque(),
                        zombie.getVitesse_de_deplacement(),
                        zombie.getChemin_image(), zombie.getId_map()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMap(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(zombieDTO.getId_zombie(), zombieDTO.getNom(), zombieDTO.getPoint_de_vie(),
                zombieDTO.getAttaque_par_seconde(), zombieDTO.getDegat_attaque(), zombieDTO.getVitesse_de_deplacement(),
                zombieDTO.getChemin_image(), zombieDTO.getId_map());
        zombieService.createZombie(zombie);
    }

    @PutMapping("/{id}")
    public void updatezombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(zombieDTO.getId_zombie(), zombieDTO.getNom(), zombieDTO.getPoint_de_vie(),
                zombieDTO.getAttaque_par_seconde(), zombieDTO.getDegat_attaque(), zombieDTO.getVitesse_de_deplacement(),
                zombieDTO.getChemin_image(), zombieDTO.getId_map());
        zombieService.updateZombie(zombie);
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable int id) {
        zombieService.deleteZombie(id);
    }
}
