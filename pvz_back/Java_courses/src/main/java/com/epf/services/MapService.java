package com.epf.services;

import com.epf.models.Map;

import java.util.List;

public interface MapService {
    Map getMap(int id);
    List<Map> getAllMaps();
    void createMap(Map map);
    void updateMap(Map map);
    void deleteMap(int id);
}
