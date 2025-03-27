package com.epf.services.impl;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;
import com.epf.services.MapService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    private final MapDAO mapDao;

    public MapServiceImpl(MapDAO mapDao) {
        this.mapDao = mapDao;
    }
    @Override
    public Map getMap(int id) {
        try {
            return mapDao.get(id);
        }catch (SQLException e){
            System.err.println("Erreur lors de la get de la map:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Map> getAllMaps() {
        try {
            return mapDao.getAll();
        }catch (SQLException e){
            System.err.println("Erreur lors de la getAll de la map:" + e.getMessage());
        }
        return null;
    }

    @Override
    public void createMap(Map map) {
        try {
            mapDao.createMap(map);
        }catch (SQLException e){
            System.err.println("Erreur lors de la creation de la map:" + e.getMessage());
        }

    }

    @Override
    public void updateMap(Map map) {
        try {
            mapDao.updateMap(map);
        }catch (SQLException e){
            System.err.println("Erreur lors de la MAJ de la map:" + e.getMessage());
        }

    }

    @Override
    public void deleteMap(int id) {
        try {
            mapDao.deleteMap(id);
        }catch (SQLException e){
            System.err.println("Erreur lors de la supression de la map:" + e.getMessage());
        }
    }
}
