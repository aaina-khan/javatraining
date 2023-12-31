package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.repository.BusRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class BusDao {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getBus() {
        return busRepository.findAll();
    }

    public Bus getBus(Long busId) {
        return busRepository.findById(busId).orElse(null);
    }

    public void addBus(Bus bus) {
        busRepository.save(bus);
    }

    public void updateBus(Long busId, Bus updatedBus) {
        Bus existingBus = busRepository.findById(busId).orElse(null);
        if (existingBus != null) {
            // Update fields as needed
            existingBus.setBusRegNumber(updatedBus.getBusRegNumber());
            existingBus.setBusType(updatedBus.getBusType());
            // Update other fields

            busRepository.save(existingBus);
        }
    }

    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }
}