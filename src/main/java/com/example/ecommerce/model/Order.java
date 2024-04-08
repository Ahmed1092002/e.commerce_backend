package com.example.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderitem")
    private OrderItem orderItem;



    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ShoppingCart shoppingCart;




    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}