# AnknaJDBCProject-Dao-CRUD-otherOperations

PROJECT STRUCTURE

bus-ticket-reservation-system/
│
├── src/
│   ├── Main.java                        # Main entry point for the application
│   ├── dao/
│   │   ├── BusDAO.java                  # DAO interface for bus operations
│   │   ├── CustomerDAO.java             # DAO interface for customer operations
│   │   ├── TicketDAO.java               # DAO interface for ticket operations
│   │   ├── impl/                        # DAO implementations
│   │       ├── BusDAOImpl.java
│   │       ├── CustomerDAOImpl.java
│   │       ├── TicketDAOImpl.java
│   ├── model/
│   │   ├── Bus.java                     # Bus entity model
│   │   ├── Customer.java                # Customer entity model
│   │   ├── Ticket.java                  # Ticket entity model
│   ├── service/
│       ├── BusService.java              # Service layer for bus-related operations
│       ├── CustomerService.java         # Service layer for customer-related operations
│       ├── TicketService.java           # Service layer for ticket-related operations
├── README.md                            # Project documentation
├── pom.xml                              # Maven project file (optional)



# Bus Ticket Reservation System

## Project Overview

The **Bus Ticket Reservation System** is a Java-based application that allows customers to book bus tickets and administrators to manage bus information, routes, and availability. It is built using **JDBC** for database interaction and follows the **DAO (Data Access Object)** design pattern to decouple the business logic from the database operations. The application supports basic operations such as booking, canceling, and viewing bus details, while ensuring smooth communication between the customer and the administrator.

## Features

### Roles:
- **Customer:**
  - Book tickets by selecting the source and destination.
  - Cancel tickets.
  - View available buses.
  
- **Administrator:**
  - Manage buses by adding, updating, or deleting bus details.
  - Confirm seat bookings and provide contact details to the customer.
  - View ticket booking information.

### Entities:
- **Bus:** Represents bus details like name, route, type, total seats, and timings.
- **Customer:** Stores customer details such as name and contact information.
- **Ticket:** Manages the booking of seats on buses by customers.

### Technologies Used:
- **Java:** Core programming language.
- **JDBC:** For interacting with the MySQL database.
- **DAO Pattern:** For separating database logic from business logic.
- **MySQL:** Backend database for storing customer, bus, and ticket data.

## Prerequisites

1. **JDK (Java Development Kit)** - Java 8 or above.
2. **MySQL** - Installed and running on `localhost:3306`.
3. **MySQL JDBC Driver** - Ensure the driver is available in your project.
4. **Maven** (if using Maven for dependency management).
