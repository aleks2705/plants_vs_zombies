package com.epf.services.impl;

import com.epf.models.Map;
import com.epf.persistance.dao.MapDAO;
import com.epf.services.MapService;

import java.util.List;

public class MapServiceImpl implements MapService {
    private final MapDAO mapDao;

    public MapServiceImpl(MapDAO mapDao) {
        this.mapDao = mapDao;
    }
    @Override
    public Map getMap(int id) {
        return mapDao.get(id);
    }

    @Override
    public List<Map> getAllMaps() {
        return mapDao.getAll();
    }

    @Override
    public void createMap(Map map) {
        mapDao.createMap(map);
    }

    @Override
    public void updateMap(Map map) {
        mapDao.updateMap(map);
    }

    @Override
    public void deleteMap(Map map) {
        mapDao.deleteMap(map);
    }
}
