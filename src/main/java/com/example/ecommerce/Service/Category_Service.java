package com.example.ecommerce.Service;
import com.example.ecommerce.Repository.Category_Repository;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Category_Service {

    @Autowired
    private Category_Repository categoryReposatory;
    private User_Service user_service;

    public Category_Service(Category_Repository categoryReposatory) {
        this.categoryReposatory = categoryReposatory;
    }

    public  List<Category> GetAllCategorys() {
      return   categoryReposatory.findAll();


    }
    public String AddCategory(Category category) {
        if (categoryReposatory.existsById(category.getId())) {


            return "this category is already added";
        }
        else
        {
            categoryReposatory.save(category);
            return "Add Product Successful";
        }


    }
    public String RemoveCategory(Category category) {
        if (categoryReposatory.existsById(category.getId())) {

            categoryReposatory.delete(category);
            return "Remove Category Successful";
        }
        else {


            return "Category is not found";

        }


    }
    public void RemoveAllCategory() {


        categoryReposatory.deleteAll();

    }

    public String  UpdateCategory(Category category) {
        if (categoryReposatory.existsById(category.getId())) {
            return "Category is not fount";

        }
        else {
            categoryReposatory.save(category);
            return "Update Category Successful";
        }
    }


    public Category GetCategoryBYname(String name) {
        return categoryReposatory.findByCategoryName(name);
    }

    public List<Products> getCategoryByUserId(long userId) {
        return categoryReposatory.getCategoryByUserId(userId) ;


    }


}
