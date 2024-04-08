package com.example.ecommerce.Repository;

import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<User,Long> {
    @Query(value = "select user from User user where 'email'=:email and 'password'=:password")
    public User getCustomerByEmailAndPassword (@Param("email") String email, @Param("password") String password);


    @Query(value = "select name from User name where name.username=:name")
    Optional <User> findByname( @Param("name") String username);

}
