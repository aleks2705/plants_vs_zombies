package com.epf.controllers;

import com.epf.dto.PlanteDTO;
import com.epf.models.Plante;
import com.epf.services.PlanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class PlanteController {
    private final PlanteService planteService;

    public PlanteController(PlanteService planteService){
        this.planteService = planteService;
    }
    @GetMapping("/{id}")
    public PlanteDTO getPlante(@PathVariable int id) {
        Plante plante = planteService.getPlante(id);
        return new PlanteDTO(plante.getId_plante(), plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return planteService.getAllPlantes().stream()
                .map(plante -> new PlanteDTO(plante.getId_plante(), plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMap(@RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(planteDTO.getId_plante(), planteDTO.getNom(), planteDTO.getPoint_de_vie(), planteDTO.getAttaque_par_seconde(), planteDTO.getDegat_attaque(), planteDTO.getCout(), planteDTO.getSoleil_par_seconde(), planteDTO.getEffet(), planteDTO.getChemin_image());
        planteService.createPlante(plante);
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(id, planteDTO.getNom(), planteDTO.getPoint_de_vie(), planteDTO.getAttaque_par_seconde(), planteDTO.getDegat_attaque(), planteDTO.getCout(), planteDTO.getSoleil_par_seconde(), planteDTO.getEffet(), planteDTO.getChemin_image());
        planteService.updatePlante(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        planteService.deletePlante(id);
    }
}
