package Main;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import dao.impl.BusDAOImpl;
import dao.impl.CustomerDAOImpl;
import dao.impl.TicketDAOImpl;
import model.Bus;
import model.Customer;
import model.Ticket;
import service.BusService;
import service.CustomerService;
import service.TicketService;

public class Main {
    public static void main(String[] args) {
        try {
            // Database Connection
            String url = "jdbc:mysql://localhost:3306/bus_reservation";
            String user = "root";
            String password = "root"; 
            Connection connection = DriverManager.getConnection(url, user, password);

            // DAOs and Services
            BusDAOImpl busDAO = new BusDAOImpl(connection);
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connection);
            TicketDAOImpl ticketDAO = new TicketDAOImpl(connection);
            BusService busService = new BusService(busDAO);
            CustomerService customerService = new CustomerService(customerDAO);
            TicketService ticketService = new TicketService(ticketDAO);

            // Scanner for User Input
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Bus");
                System.out.println("2. View Buses");
                System.out.println("3. Add Customer");
                System.out.println("4. Book Ticket");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1: // Add Bus
                        System.out.print("Enter Bus Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Bus Route: ");
                        String route = scanner.next();
                        System.out.print("Enter Bus Type (AC/non-AC): ");
                        String type = scanner.next();
                        System.out.print("Enter Total Seats: ");
                        int totalSeats = scanner.nextInt();
                        Bus bus = new Bus(name, route, type, totalSeats, 0, "10:00:00", "14:00:00");
                        busService.addBus(bus);
                        break;

                    case 2: // View Buses
                        List<Bus> buses = busService.getAllBuses();
                        System.out.println("Available Buses:");
                        for (Bus b : buses) {
                            System.out.println(b.getName());
                        }
                        break;

                    case 3: // Add Customer
                        System.out.print("Enter Customer Name: ");
                        String customerName = scanner.next();
                        System.out.print("Enter Customer Contact: ");
                        String contact = scanner.next();
                        Customer customer = new Customer(customerName, contact);
                        customerService.addCustomer(customer);
                        break;

                    case 4: // Book Ticket
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        System.out.print("Enter Bus ID: ");
                        int busId = scanner.nextInt();
                        Ticket ticket = new Ticket(customerId, busId);
                        ticketService.bookTicket(ticket);
                        break;

                    case 5: // Exit
                        scanner.close();
                        connection.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

