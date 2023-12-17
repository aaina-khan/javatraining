package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.model.BusRouteMappingRequest;

import java.util.List;
import java.util.Map;

public interface BusRouteMappingServiceInterface {

    List<BusRouteMapping> getMappingsForRoute(Long routeId);
    Map<String,Object> addBusRoute(BusRouteMappingRequest mapping);

}
