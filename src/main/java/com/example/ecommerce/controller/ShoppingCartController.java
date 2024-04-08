package com.example.ecommerce.controller;

import com.example.ecommerce.Service.ShoppingCartService;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;


    @PostMapping("/{cartId}/product/{productId}")
    public Order addProductToCart(
            @PathVariable Long cartId,
            @PathVariable Long productId,
            @RequestParam Integer quantity
    ) {

        return shoppingCartService.addProductToCart(cartId, productId, quantity);


    }

    @PostMapping("/RemoveProductFromCart")
    public String removeProductFromCart(@RequestParam Long cartId, @RequestParam Long orderId) {
        return shoppingCartService.removeProductFromCart(cartId, orderId);


    }



    @PostMapping("/GetCartBYUser")
    public ShoppingCart getCartByUser(@RequestParam Long userId)
    {  return shoppingCartService.getCartByUser(userId);



    }

    @PostMapping("/createCartByUser")
    public ShoppingCart createCartByUser(@RequestParam Long userId)
    { return shoppingCartService.createCartForUser(userId);}
}
