package com.example.OnlineGrocery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineGrocery.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
