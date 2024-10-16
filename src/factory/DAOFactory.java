package factory;

import dao.AdminDAO;
import dao.BusDAO;
import dao.CustomerDAO;
import dao.RouteDAO;
import dao.TicketDAO;
import dao.impl.BusDAOImpl;
import dao.impl.CustomerDAOImpl;
import dao.impl.RouteDAOImpl;
import dao.impl.TicketDAOImpl;

public class DAOFactory {
    public static BusDAO getBusDAO() {
        return new BusDAOImpl(null);
    }

    public static RouteDAO getRouteDAO() {
        return new RouteDAOImpl();
    }

    public static TicketDAO getTicketDAO() {
        return new TicketDAOImpl(null);
    }

    public static CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl(null);
    }

    public static AdminDAO getAdminDAO() {
        return new AdminDAO();
    }
}


//Explanation: The Factory pattern is used to decouple the instantiation of DAO objects. It provides a single point of access to all DAO instances, allowing for better code maintenance and extension.
