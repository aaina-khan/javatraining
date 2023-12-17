package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.Bus;

import java.util.List;

public interface BusDaoInterface {

    List<Bus> getBus();
    Bus getBus(Long busId);
    void addBus(Bus bus);

    void updateBus(Long busId, Bus updatedBus);

    void deleteBus(Long busId);
}
