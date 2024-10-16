package dao;


import java.util.List;

import model.Bus;

public interface BusDAO {
    void addBus(Bus bus);
    List<Bus> getAllBuses();
    Bus getBusById(int id);
    void updateBus(Bus bus);
    void deleteBus(int id);
}



