package com.example.ecommerce.Repository;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Category_Repository extends JpaRepository<Category,Integer> {

    @Query(value = "select Category from Category Category where 'Category'=:Category")
    public Category findByCategoryName(@Param("Category") String Category);


    @Query(value = "select p from UserProductCategory p where p.category.nameOfCategory = :nameofCategory")
    List<Products> getCategoryByUserId(@Param("nameofCategory") long userId);



}
