package com.example.ecommerce.controller;

import com.example.ecommerce.Service.OrderService;
import com.example.ecommerce.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/admin/all-orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @DeleteMapping("/user/deleteOrder")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
    @PostMapping("/user/GetAllOrdersOfuser")
    public List<Order> getAllOrdersOFUser(@RequestParam Long id) {

        return orderService.getOrdersByUserId(id);
    }

    @PostMapping("/getorders/all")
    public List<Order> getOrderById(@RequestParam Long id) {

        return Collections.singletonList(orderService.getOrderById(id));
    }

}
