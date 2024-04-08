package com.example.ecommerce.controller;

import com.example.ecommerce.Service.*;
import com.example.ecommerce.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.model.Order;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class PublicControllerForAll_Users {
    @Autowired

    private Product_Service productService;
    private Category_Service categoryService;







    @PostMapping("/search/FindProductbyname/all")
    public String FindProductbyname(String name) {
        return productService.findByProduuctsName(name);

    }

//category controller
@GetMapping("/search/findCategoryBYname/all")
public Category getCategoryByName(@RequestParam String name) {
    return categoryService.GetCategoryBYname(name);
}


    @GetMapping("/allCategory/all/all")
    public List<Category> allCategory() {
        return categoryService.GetAllCategorys();
    }






}
