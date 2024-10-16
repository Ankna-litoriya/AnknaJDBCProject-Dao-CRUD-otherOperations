package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.BusDAO;
import dao.RouteDAO;
import dao.TicketDAO;
import dao.CustomerDAO;
import model.Bus;
import model.Customer;
import service.ReservationService;
import dao.impl.*;

public class ReservationServiceTest {
    private ReservationService reservationService;
    private BusDAO busDAO;
    private RouteDAO routeDAO;
    private TicketDAO ticketDAO;
    private CustomerDAO customerDAO;

    @Before
    public void setUp() {
        busDAO = new BusDAOImpl(null);
        routeDAO = new RouteDAOImpl();
        ticketDAO = new TicketDAOImpl(null);
        customerDAO = new CustomerDAOImpl(null);
        reservationService = new ReservationService(busDAO, routeDAO, ticketDAO, customerDAO);
    }

    @Test
    public void testBookTicket() {
        try {
            reservationService.bookTicket(1, 101, "2024-10-10");
            assertTrue(true); // If no exception, booking is successful
        } catch (Exception e) {
            fail("Booking failed: " + e.getMessage());
        }
    }

    @Test
    public void testCancelTicket() {
        try {
            reservationService.cancelTicket(1);
            assertTrue(true); // If no exception, cancellation is successful
        } catch (Exception e) {
            fail("Cancellation failed: " + e.getMessage());
        }
    }
}
