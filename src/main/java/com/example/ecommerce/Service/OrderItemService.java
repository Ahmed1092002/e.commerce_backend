package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.OrderItemRepository;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderItemService {
    @Autowired
    private final OrderItemRepository orderItemRepository;
    private final Product_Service productService;

    public OrderItemService(OrderItemRepository orderItemRepository, Product_Service productService) {
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Object createOrderItem(Products product, Integer quantity) {
        if (product.getAvailableQuantity()>=quantity)
        {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        saveOrderItem(orderItem);
        return orderItem;
        }
        else {

            return "this Product is not available";
        }


    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderItem not found"));
    }

    public void deleteOrderItem(OrderItem orderItem) {
        orderItemRepository.delete(orderItem);
    }
}
