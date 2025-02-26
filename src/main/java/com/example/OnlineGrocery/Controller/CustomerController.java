package com.example.OnlineGrocery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineGrocery.Entity.Customer;
import com.example.OnlineGrocery.Service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity <Customer> getCustomerByIdRequest(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    
    @GetMapping 
    public List<Customer> getAllTheCustomersRequest(){
        return customerService.getAllCustomers();
    }
    
    @PostMapping 
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerDetails(@PathVariable Long id, @Valid Customer customer){
        Customer updatedCustomer=customerService.updateCustomer(customer, id);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}


