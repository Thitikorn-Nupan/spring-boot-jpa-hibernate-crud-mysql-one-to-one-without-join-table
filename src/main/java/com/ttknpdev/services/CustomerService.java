package com.ttknpdev.services;

import com.ttknpdev.entities.Customer;
import com.ttknpdev.repositoties.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }
}
