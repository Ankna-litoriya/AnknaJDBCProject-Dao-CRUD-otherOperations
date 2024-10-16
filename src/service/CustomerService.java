package service;

import java.util.List;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }
}

