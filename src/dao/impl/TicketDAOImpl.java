package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDAO;
import model.Ticket;

public class TicketDAOImpl implements TicketDAO {
    private Connection connection;

    public TicketDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void bookTicket(Ticket ticket) {
        String sql = "INSERT INTO Ticket (customerId, busId) VALUES (?, ?)";
        String updateBusSql = "UPDATE Bus SET bookedSeats = bookedSeats + 1 WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ticket.getCustomerId());
            statement.setInt(2, ticket.getBusId());
            statement.executeUpdate();
            // Update the booked seats in Bus table
            try (PreparedStatement updateStatement = connection.prepareStatement(updateBusSql)) {
                updateStatement.setInt(1, ticket.getBusId());
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM Ticket";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setCustomerId(resultSet.getInt("customerId"));
                ticket.setBusId(resultSet.getInt("busId"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

	@Override
	public Ticket getTicketById(Ticket ticketId) {
		// TODO Auto-generated method stub
		return null;
	}
}

