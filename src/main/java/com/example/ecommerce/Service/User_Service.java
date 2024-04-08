package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.User_Repository;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class User_Service  {
@Autowired
    private User_Repository userRepository;
    private PasswordEncoder passwordEncoder;

    public User_Service(User_Repository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveCustomer(User user) {
        return userRepository.save(user);
    }



    public User register(String username, String password, String roleName) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));


        Role role = new Role();
        role.setName(roleName);


        user.getRoles().add(role);


        return userRepository.save(user);
    }

    public String login(String username, String password) {
        User user = userRepository.findByname(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
        if (user.getRole().getName().equals("ADMIN")) {
            return  "redirect:/api/admin";
        } else {
            return "redirect:/api/user";
        }
    }



    public String update_Customer(User user) {
        userRepository.save(user);
        return "Updated";
    }


    public String DeleteCustomer(User user) {
        userRepository.delete(user);
        return "User deleted successfully";

    }

    public String GetAllUsers() {
        userRepository.findAll();
        return "get all successfully";


    }



    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


}




