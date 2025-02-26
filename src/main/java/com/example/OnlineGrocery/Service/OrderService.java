package com.example.OnlineGrocery.Service;

import java.util.List;

import com.example.OnlineGrocery.DTO.OrderRequest;
import com.example.OnlineGrocery.Entity.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderRequest orderRequest);
    Order updateOrder(Long id,OrderRequest orderRequest);
    void deleteOrder(Long id);
}
