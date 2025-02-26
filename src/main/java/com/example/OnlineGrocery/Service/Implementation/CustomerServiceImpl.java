package com.example.OnlineGrocery.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineGrocery.Entity.Customer;
import com.example.OnlineGrocery.Exception.ResourceNotFoundException;
import com.example.OnlineGrocery.Repository.CustomerRepository;
import com.example.OnlineGrocery.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer c=getCustomerById(id);
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setAddress(customer.getAddress());
        c.setPhone(customer.getPhone());
        return customerRepository.save(c);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer c=getCustomerById(id);
        customerRepository.delete(c);
    }

}
