package com.example.OnlineGrocery.Service;

import java.util.List;

import com.example.OnlineGrocery.Entity.Customer;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer,Long id);
    void deleteCustomer(Long id);
}
