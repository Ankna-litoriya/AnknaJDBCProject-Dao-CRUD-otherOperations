package service;

import java.util.List;

import dao.BusDAO;
import model.Bus;

public class BusService {
    private BusDAO busDAO;

    public BusService(BusDAO busDAO) {
        this.busDAO = busDAO;
    }

    public void addBus(Bus bus) {
        busDAO.addBus(bus);
    }

    public List<Bus> getAllBuses() {
        return busDAO.getAllBuses();
    }

    public Bus getBusById(int id) {
        return busDAO.getBusById(id);
    }

    public void updateBus(Bus bus) {
        busDAO.updateBus(bus);
    }

    public void deleteBus(int id) {
        busDAO.deleteBus(id);
    }
}
