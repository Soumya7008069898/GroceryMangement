package com.example.OnlineGrocery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineGrocery.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
