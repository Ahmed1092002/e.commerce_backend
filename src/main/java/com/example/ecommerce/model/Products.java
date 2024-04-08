package com.example.ecommerce.model;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nameOfProduct")
  @NotNull
    @Basic(optional = false)
    private String nameOfProduct;
    @Column(name = "Title")

    @NotNull
    private String Title;
    @Column(name = "Price")
    @NotNull
    private Integer price;
    @Column(name = "NumberOfItems")
    @NotNull
    private Integer NumberOfItems;
    @NotNull
    @Column(name = "availableQuantity")
    private int availableQuantity;


    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;




}
