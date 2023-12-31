package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.model.BusRouteMappingRequest;
import com.apsrtc.busmanagement.service.BusRouteMappingService;
import com.apsrtc.busmanagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/bus")
public class BusController implements BusControllerInterface {

    @Autowired
    private BusService busService;

    @Autowired
    private BusRouteMappingService busRouteMappingService;


    @PostMapping
    public ResponseEntity<Map<String,Object>> addBus(@RequestBody Bus bus) {
        Map<String,Object> response = new HashMap();
        if (bus.getBusRegNumber() == null || bus.getBusType() == null) {
            response.put("message","Missing busRegNumber or busType");
            response.put("statusCode",HttpStatus.BAD_REQUEST);
        }
        try {
            busService.addBus(bus);
            response.put("message","new bus added");
            response.put("statusCode",HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            response.put("message","Bus with busRegNumber already exist");
            response.put("statusCode",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));

    }

    @PutMapping("/{busId}")
    public ResponseEntity<Map<String,Object>> updateBus(@PathVariable Long busId, @RequestBody Bus updatedBus) {
        Map<String,Object> response = new HashMap();
        String result = busService.updateBus(busId, updatedBus);
        if (Objects.equals(result, "updated")) {
            response.put("message","Bus information updated");
            response.put("statusCode",HttpStatus.OK);

        } else if (Objects.equals(result,"not found")){
            response.put("message","Bus not found");
            response.put("statusCode",HttpStatus.BAD_REQUEST);
        } else {
            response.put("message","Update failed");
            response.put("statusCode",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<Map<String,Object>> deleteBus(@PathVariable Long busId) {
        Map<String,Object> response = new HashMap();
        try {
            busService.deleteBus(busId);
            response.put("message","Deleted");
            response.put("statusCode",HttpStatus.OK);
        }catch (Exception e){
            response.put("message","Failed");
            response.put("statusCode",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));
    }

    @PostMapping("/map-route")
    public ResponseEntity<Map<String,Object>> MapRoute(@RequestBody BusRouteMappingRequest busRouteMapping) {
        System.out.println("map-route");
        Map<String,Object> response = busRouteMappingService.addBusRoute(busRouteMapping);

        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));

    }

}