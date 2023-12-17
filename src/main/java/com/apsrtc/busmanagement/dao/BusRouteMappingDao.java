package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.repository.BusRouteMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusRouteMappingDao {
    @Autowired
    private BusRouteMappingRepository busRouteMappingRepository;

    public List<BusRouteMapping> getAllBusRoutes() {
        return busRouteMappingRepository.findAll();
    }

    public List<BusRouteMapping> getBusForRoute(Long routeId) {
        return busRouteMappingRepository.findByRouteId(routeId);
    }

    public void mapBusToRoute(BusRouteMapping mapping) {
        System.out.println("Saving mapping");
        try {
            busRouteMappingRepository.save(mapping);
        }catch (Exception e){
            System.out.println("error : "+e.toString());
        }
    }

    public void removeMapping(Long mappingId) {
        busRouteMappingRepository.deleteById(mappingId);
    }

}
