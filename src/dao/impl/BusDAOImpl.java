package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.BusDAO;
import model.Bus;

public class BusDAOImpl implements BusDAO {
    private Connection connection;

    public BusDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addBus(Bus bus) {
        String sql = "INSERT INTO Bus (name, route, type, totalSeats, bookedSeats, departureTime, arrivalTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bus.getName());
            statement.setString(2, bus.getRoute());
            statement.setString(3, bus.getType());
            statement.setInt(4, bus.getTotalSeats());
            statement.setInt(5, bus.getBookedSeats());
            statement.setTime(6, Time.valueOf(bus.getDepartureTime()));
            statement.setTime(7, Time.valueOf(bus.getArrivalTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM Bus";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Bus bus = new Bus();
                bus.setId(resultSet.getInt("id"));
                bus.setName(resultSet.getString("name"));
                bus.setRoute(resultSet.getString("route"));
                bus.setType(resultSet.getString("type"));
                bus.setTotalSeats(resultSet.getInt("totalSeats"));
                bus.setBookedSeats(resultSet.getInt("bookedSeats"));
                bus.setDepartureTime(resultSet.getTime("departureTime").toString());
                bus.setArrivalTime(resultSet.getTime("arrivalTime").toString());
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }

    @Override
    public Bus getBusById(int id) {
        Bus bus = null;
        String sql = "SELECT * FROM Bus WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    bus = new Bus();
                    bus.setId(resultSet.getInt("id"));
                    bus.setName(resultSet.getString("name"));
                    bus.setRoute(resultSet.getString("route"));
                    bus.setType(resultSet.getString("type"));
                    bus.setTotalSeats(resultSet.getInt("totalSeats"));
                    bus.setBookedSeats(resultSet.getInt("bookedSeats"));
                    bus.setDepartureTime(resultSet.getTime("departureTime").toString());
                    bus.setArrivalTime(resultSet.getTime("arrivalTime").toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }

    @Override
    public void updateBus(Bus bus) {
        String sql = "UPDATE Bus SET name = ?, route = ?, type = ?, totalSeats = ?, bookedSeats = ?, departureTime = ?, arrivalTime = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bus.getName());
            statement.setString(2, bus.getRoute());
            statement.setString(3, bus.getType());
            statement.setInt(4, bus.getTotalSeats());
            statement.setInt(5, bus.getBookedSeats());
            statement.setTime(6, Time.valueOf(bus.getDepartureTime()));
            statement.setTime(7, Time.valueOf(bus.getArrivalTime()));
            statement.setInt(8, bus.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBus(int id) {
        String sql = "DELETE FROM Bus WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
