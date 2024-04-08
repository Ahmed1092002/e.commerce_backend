package com.example.ecommerce.Repository;

import com.example.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.user.id = :id")
    List<Order> findByUserId(@Param("id") Long id);


    @Query("select o from Order o where o.shoppingCart.id = :id")
    List<Order> findByShoppingCartId(@Param("id") Long id);
}