package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.model.BusRouteMappingRequest;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;

public interface BusControllerInterface {

    ResponseEntity<Map<String,Object>> addBus(Bus bus);

    ResponseEntity<Map<String,Object>> updateBus(Long busId, Bus updatedBus);
    ResponseEntity<Map<String,Object>> deleteBus(Long busId);

    ResponseEntity<Map<String,Object>> MapRoute(BusRouteMappingRequest busRouteMapping);

}
