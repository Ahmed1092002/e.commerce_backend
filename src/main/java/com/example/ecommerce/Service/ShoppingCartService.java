package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.OrderRepository;
import com.example.ecommerce.Repository.ShoppingCartRepository;
import com.example.ecommerce.Repository.User_Repository;
import com.example.ecommerce.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {
    @Autowired
    private final ShoppingCartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final Product_Service productService;
    private final User_Repository userRepository;
    private final OrderItemService orderItemService;
    private final OrderService orderService;;

    public ShoppingCartService(ShoppingCartRepository cartRepository,
                               OrderRepository orderRepository,
                               Product_Service productService,
                               User_Repository userRepository, OrderItemService orderItemService, OrderService orderService) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.userRepository = userRepository;
        this.orderItemService = orderItemService;
        this.orderService = orderService;
    }

    public ShoppingCart getCartByUser(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Shopping cart not found"));
    }




    public List<Order> getOrdersByCart(Long cartId) {
        return orderRepository.findByShoppingCartId(cartId);
    }





    private ShoppingCart getShoppingCartById(Long cartId) {

        return cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Shopping cart not found"));
    }




    public Order addProductToCart(Long cartId, Long productId, Integer quantity) {
        ShoppingCart cart=  getShoppingCartById(cartId);
        Products product =productService.getProductById(productId);
        Object orderItem= orderItemService.createOrderItem(product,quantity);
        Order order = orderService.createOrder((OrderItem) orderItem);
        addOrderToCart(order,cart);
        saveShoppingCart(cart);
        return order;
    }




    private void addOrderToCart(Order order, ShoppingCart cart) {
        cart.getOrders().add(order);
    }

    private void saveShoppingCart(ShoppingCart cart) {
        cartRepository.save(cart);
    }





    public String removeProductFromCart(Long cartId, Long orderId) {
        ShoppingCart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Shopping cart not found"));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        if (!order.getShoppingCart().equals(cart)) {
            throw new IllegalArgumentException("Order does not belong to cart");
        }
        orderRepository.delete(order);
        return "Order Has been deleted ";
    }


    public ShoppingCart createCartForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }
}