package com.example.ecommerce.controller;

import com.example.ecommerce.Service.User_Service;
import com.example.ecommerce.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    @Autowired
    private User_Service userService;
    @PostMapping("/register")
    public ResponseEntity<User> register (  @RequestParam  String username,@RequestParam String password,@RequestParam String roleName) {
        User newUser = userService.register(username,password,roleName);
        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        String user = userService.login(username, password);
        return String.valueOf(ResponseEntity.ok(user));
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        // TODO: Implement logout logic
        return ResponseEntity.ok().build();
    }
}