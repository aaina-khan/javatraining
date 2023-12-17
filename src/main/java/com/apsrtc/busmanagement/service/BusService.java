package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.dao.BusDao;
import com.apsrtc.busmanagement.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusDao busDao;

    public void addBus(Bus bus) {
        busDao.addBus(bus);
    }

    public String updateBus(Long busId, Bus updatedBus) {
        Bus existingBus = busDao.getBus(busId);
        if (existingBus != null) {
            // Update fields as needed
            existingBus.setBusRegNumber(updatedBus.getBusRegNumber());
            existingBus.setBusType(updatedBus.getBusType());
            // Update other fields

            busDao.addBus(existingBus);
            return "updated";
        } else {
            return "not found";
        }
    }

    public void deleteBus(Long busId) {
        busDao.deleteBus(busId);
    }
}