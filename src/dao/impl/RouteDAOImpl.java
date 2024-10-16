package dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.RouteDAO;
import model.Route;

public class RouteDAOImpl implements RouteDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bus_ticket_reservation";
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public Route getRouteById(int routeId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM routes WHERE route_id = ?")) {
            stmt.setInt(1, routeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Route();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM routes");
            while (rs.next()) {
                routes.add(new Route());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public void addRoute(Route route) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO routes (source, destination, distance_km) VALUES (?, ?, ?)")) {
            stmt.setString(1, route.getSource());
            stmt.setString(2, route.getDestination());
            stmt.setInt(3, route.getDistanceKm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoute(Route route) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("UPDATE routes SET source = ?, destination = ?, distance_km = ? WHERE route_id = ?")) {
            stmt.setString(1, route.getSource());
            stmt.setString(2, route.getDestination());
            stmt.setInt(3, route.getDistanceKm());
            stmt.setInt(4, route.getRouteId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoute(int routeId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM routes WHERE route_id = ?")) {
            stmt.setInt(1, routeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
