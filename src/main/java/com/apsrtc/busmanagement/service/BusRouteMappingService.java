package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.dao.BusDao;
import com.apsrtc.busmanagement.dao.BusRouteMappingDao;
import com.apsrtc.busmanagement.dao.RouteDao;
import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.model.BusRouteMappingRequest;
import com.apsrtc.busmanagement.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusRouteMappingService implements BusRouteMappingServiceInterface {

    @Autowired
    private BusRouteMappingDao busRouteMappingDao;

    @Autowired
    private BusDao busDao;
    @Autowired
    private RouteDao routeDao;

    public List<BusRouteMapping> getMappingsForRoute(Long routeId) {
        return busRouteMappingDao.getBusForRoute(routeId);
    }

    public Map<String,Object> addBusRoute(BusRouteMappingRequest busRouteMappingRequest) {
        Map<String,Object> response = new HashMap();

        if (busRouteMappingRequest.getBusId() == null || busRouteMappingRequest.getRouteId() == null || busRouteMappingRequest.getStartTime() == null || busRouteMappingRequest.getEndTime() == null ) {
            response.put("message","Missing bus or route or startTime or endTime");
            response.put("statusCode", HttpStatus.BAD_REQUEST);
        }else{
            try {
                Bus bus = busDao.getBus(busRouteMappingRequest.getBusId());
                Route route = routeDao.getRoute(busRouteMappingRequest.getRouteId());

                BusRouteMapping busRouteMapping = new BusRouteMapping();
                busRouteMapping.setBus(bus);
                busRouteMapping.setRoute(route);
                busRouteMapping.setRoute(route);
                busRouteMapping.setStartTime(busRouteMappingRequest.getStartTime());
                busRouteMapping.setEndTime(busRouteMappingRequest.getEndTime());

                busRouteMappingDao.mapBusToRoute(busRouteMapping);
                response.put("message","New route added");
                response.put("statusCode",HttpStatus.CREATED);
            } catch (DataIntegrityViolationException e) {
                response.put("message","Mapping with bus and route already exist");
                response.put("statusCode",HttpStatus.BAD_REQUEST);
            }
        }

    return response;

    }

}