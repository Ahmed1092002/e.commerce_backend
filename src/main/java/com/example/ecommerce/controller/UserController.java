package com.example.ecommerce.controller;

import com.example.ecommerce.Service.User_Service;
import com.example.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private User_Service user_service;

    @GetMapping("/api/admin")
    public String adminPanal ()
    {
        return "admin panal";

    }

    @GetMapping("/serverAdmin/GetAllUsers/all")
    public String getAllUsers() {
        return user_service.GetAllUsers();

    }
@PostMapping("/serverAdmin/GetUserbyId/all")
    public Optional<User> findUserById(Long id) {
        return user_service.findUserById(id);
    }

    @DeleteMapping("/deleteUser/all")
    public String deleteUser (User user){
        return user_service.DeleteCustomer(user);
    }
    @PostMapping("/UpdateUser/all")
    public String update_Customer(User user) {
        return user_service.update_Customer(user);


    }
}
