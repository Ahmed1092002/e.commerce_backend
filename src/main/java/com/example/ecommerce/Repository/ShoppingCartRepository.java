package com.example.ecommerce.Repository;

import com.example.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("select cart from ShoppingCart cart where cart.user.id = :id")
    Optional<ShoppingCart> findByUserId(@Param("id") Long id);



}