package ec.edu.espe.Billing.controller;

import ec.edu.espe.Billing.model.ICustomer;
import ec.edu.espe.Billing.model.Customer;
import java.util.List;

/**
 * @author Didier Elbay
 */
public class CustomerController {
    
    private final ICustomer customerRepository;

    public CustomerController(ICustomer customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean registerCustomer(Customer customer) {
        if (customer == null || customer.getRuc().trim().isEmpty()) return false;
        return customerRepository.save(customer);
    }

    public Customer getCustomerByRuc(String ruc) {
        if (ruc == null || ruc.trim().isEmpty()) return null;
        return customerRepository.findByRuc(ruc);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public boolean updateCustomer(Customer customer) {
        if (customer == null || customer.getRuc().trim().isEmpty()) return false;
        return customerRepository.update(customer);
    }

    public boolean deleteCustomer(String ruc) {
        if (ruc == null || ruc.trim().isEmpty()) return false;
        return customerRepository.delete(ruc);
    }
}
