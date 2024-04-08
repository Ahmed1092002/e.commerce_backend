package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.OrderRepository;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    private final Product_Service productService;


    public OrderService(OrderRepository orderRepository, Product_Service productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }

    public List<Order> getOrdersByUserId(Long userId) {

        return orderRepository.findByUserId(userId);
    }


    public Order createOrder(OrderItem orderItem) {

        Order order = new Order();
        order.setOrderItem(orderItem);
        orderRepository.save(order);

        return order;
    }


    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}