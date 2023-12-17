package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.Route;
import com.apsrtc.busmanagement.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteDao {

    @Autowired
    private RouteRepository routeRepository;

    public Route getRoute(Long routeId){
        return routeRepository.findById(routeId).orElse(null);
    }
}
