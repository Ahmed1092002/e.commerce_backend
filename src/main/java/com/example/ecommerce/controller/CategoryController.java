package com.example.ecommerce.controller;

import com.example.ecommerce.Service.Category_Service;
import com.example.ecommerce.Service.Product_Service;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private Category_Service categoryService;
    private Product_Service productService;

    @PostMapping("/admin/category/AddCategory")
    public String addCategory(@RequestBody Category category) {
        return categoryService.AddCategory(category);
    }

    @DeleteMapping("/admin/removeCategory")
    public String removeCategory(@RequestBody Category category) {
        return categoryService.RemoveCategory(category);
    }
    @DeleteMapping("/admin/removeAllCategory")
    public void removeAllCategory() {
        categoryService.RemoveAllCategory();
    }

    @PutMapping("/admin/UpdateCategory")
    public String updateCategory(@RequestBody Category category) {
        return categoryService.UpdateCategory(category);
    }

    @GetMapping("/admin/categories")
    public ResponseEntity<List<Category>> getCategoriesForUser(@RequestParam Long userId) {
        List<Products> products = productService.getProductsByUserId(userId);
        List<Category> categories = products.stream().map(Products::getCategory).collect(Collectors.toList());
        return ResponseEntity.ok().body(categories);
    }
}
