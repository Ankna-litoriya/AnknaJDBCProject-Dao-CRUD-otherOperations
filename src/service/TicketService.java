package service;

import java.util.List;

import dao.TicketDAO;
import model.Ticket;

public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void bookTicket(Ticket ticket) {
        ticketDAO.bookTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }
}
