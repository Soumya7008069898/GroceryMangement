package com.example.OnlineGrocery.Service.Implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineGrocery.DTO.OrderRequest;
import com.example.OnlineGrocery.Entity.Customer;
import com.example.OnlineGrocery.Entity.GroceryItem;
import com.example.OnlineGrocery.Entity.Order;
import com.example.OnlineGrocery.Exception.ResourceNotFoundException;
import com.example.OnlineGrocery.Repository.CustomerRepository;
import com.example.OnlineGrocery.Repository.GroceryItemRepository;
import com.example.OnlineGrocery.Repository.OrderRepository;
import com.example.OnlineGrocery.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
       return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer c=customerRepository.findById(orderRequest.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("customer not found"));
        List<GroceryItem> items=groceryItemRepository.findAllById(orderRequest.getGroceryIds());
        
        if(items.size()!=orderRequest.getGroceryIds().size()){
            throw new RuntimeException("one or more product missing");
        }

        double totalItemsPrice=items.stream().mapToDouble(item -> item.getPrice()*item.getQuantity()).sum();

        Order order=new Order();
        order.setCustomer(c);
        order.setOrderDate(LocalDate.now());
        order.setGroceryItems(items);
        order.setTotalPrice(totalItemsPrice);

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, OrderRequest orderRequest) {
        Order o=getOrderById(id);
        List<GroceryItem> items=groceryItemRepository.findAllById(orderRequest.getGroceryIds());
        double totalPrice=items.stream().mapToDouble(item -> item.getPrice()).sum();

        o.setGroceryItems(items);
        o.setTotalPrice(totalPrice);
        o.setOrderDate(LocalDate.now());
        return orderRepository.save(o);
    }

    @Override
    public void deleteOrder(Long id) {
        Order o=getOrderById(id);
        orderRepository.delete(o);
    }

}
