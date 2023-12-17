package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.BusRouteMapping;

import java.util.List;

public interface BusRouteMappingDaoInterface {
    List<BusRouteMapping> getAllMappings();
    List<BusRouteMapping> getMappingsForRoute(Long routeId);
    void addBusRoute(BusRouteMapping mapping);
    void removeBusFromRoute(Long mappingId);
}
