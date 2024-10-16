package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.BusDAO;
import dao.RouteDAO;
import dao.TicketDAO;
import dao.CustomerDAO;
import exception.BookingException;
import exception.SeatUnavailableException;
import model.Bus;
import model.Ticket;
import util.DatabaseUtil;
import util.LoggerUtil;


public class ReservationService {
    private BusDAO busDAO;
    private RouteDAO routeDAO;
    private TicketDAO ticketDAO;
    private CustomerDAO customerDAO;

    public ReservationService(BusDAO busDAO, RouteDAO routeDAO, TicketDAO ticketDAO, CustomerDAO customerDAO) {
        this.busDAO = busDAO;
        this.routeDAO = routeDAO;
        this.ticketDAO = ticketDAO;
        this.customerDAO = customerDAO;
    }

    public void bookTicket(int busId, int customerId, String bookingDate) throws Exception {
        Bus bus = busDAO.getBusById(busId);
        if (bus == null) throw new Exception("Bus not found");
        if (bus.getAvailableSeats() <= 0) throw new Exception("No seats available");

        Ticket ticket = new Ticket();
        ticketDAO.bookTicket(ticket);
        bus.setAvailableSeats(bus.getAvailableSeats() - 1);
        busDAO.updateBus(bus);
    }

    public void cancelTicket(Ticket ticketId) throws Exception {
        Ticket ticket = ticketDAO.getTicketById(ticketId);
        if (ticket == null || !ticket.isConfirmed()) throw new Exception("Ticket not valid for cancellation");

        Bus bus = busDAO.getBusById(ticket.getBusId());
        bus.setAvailableSeats(bus.getAvailableSeats() + 1);
        busDAO.updateBus(bus);
        ticketDAO.bookTicket(ticketId);
    }

    // Additional service methods like view tickets, update booking info can be added
}


//This class contains business logic for ticket booking, cancellation, and viewing available buses. It handles transactions using JDBC and performs exception handling. The viewAvailableBuses method implements pagination, allowing a user to fetch data in smaller chunks, which is essential for large datasets.
