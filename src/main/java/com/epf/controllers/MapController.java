package com.epf.controllers;

import com.epf.dto.MapDTO;
import com.epf.models.Map;
import com.epf.services.MapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/{id}")
    public MapDTO getMap(@PathVariable int id) {
        Map map = mapService.getMap(id);
        return new MapDTO(map.getId_map(), map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    @GetMapping
    public List<MapDTO> getAllMaps() {
        return mapService.getAllMaps().stream()
                .map(map -> new MapDTO(map.getId_map(), map.getLigne(), map.getColonne(), map.getChemin_image()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMap(@RequestBody MapDTO mapDTO) {
        Map map = new Map(mapDTO.getId(), mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        mapService.createMap(map);
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable int id, @RequestBody MapDTO mapDTO) {
        Map map = new Map(id, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        mapService.updateMap(map);
    }

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable int id) {
        mapService.deleteMap(id);
    }
}
