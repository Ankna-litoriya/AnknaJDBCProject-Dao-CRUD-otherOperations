package dao;

import java.util.List;

import model.Ticket;

public interface TicketDAO {
    void bookTicket(Ticket ticket);
    List<Ticket> getAllTickets();
	Ticket getTicketById(Ticket ticketId);
}
