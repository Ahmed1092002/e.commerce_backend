package com.example.ecommerce.controller;

import com.example.ecommerce.Service.Product_Service;
import com.example.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private Product_Service productService;


    @GetMapping("/getAllProducts/all")
    public String getAllProducts() {
        return productService.GetAllProducts();
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@RequestBody Products product) {
        return productService.AddProduct(product);
    }

    @DeleteMapping("/admin/removeProductBYId/{id}")
    public String removeProductById(@RequestParam Integer id) {
        productService.RemoveProductByid(id);
        return "Product removed successfully";
    }

    @PutMapping("/admin/UpdateProduct")
    public String updateProduct(@RequestBody Products product) {
        return productService.UpdateProduct(product);
    }
    @GetMapping("/admin/products")
    public ResponseEntity<List<Products>> getProductsForUser(@RequestParam Long userId) {
        List<Products> products = productService.getProductsByUserId(userId);
        return ResponseEntity.ok().body(products);
    }



}
