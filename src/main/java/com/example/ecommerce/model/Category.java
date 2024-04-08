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
@Table(name = "Category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "nameOfCategory")
    @NotNull
    @Basic(optional = false)

    private String nameOfCategory;

}
