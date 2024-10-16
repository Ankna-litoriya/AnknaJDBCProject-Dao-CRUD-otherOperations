package dao;

import java.util.List;

import model.Route;

public interface RouteDAO {
    Route getRouteById(int routeId);
    List<Route> getAllRoutes();
    void addRoute(Route route);
    void updateRoute(Route route);
    void deleteRoute(int routeId);
}
