package com.example.ecommerce.Repository;

import com.example.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Products_Repository extends JpaRepository<Products, Integer> {
    @Query(value = "select Products from Products Products where 'Products'=:Products")
    public Products findByProduuctsName(@Param("Products") String Products);
    @Query("select p from Products p where p.category.id = :id")
    List<Products> findByCategoryId(@Param("id") Long id);

@Query(value = "select p from UserProductCategory p where p.product.nameOfProduct = :nameofproduct")
    List<Products> getProductsByUserId( @Param("nameofproduct") Long userId);

}