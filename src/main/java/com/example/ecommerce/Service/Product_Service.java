package com.example.ecommerce.Service;
import com.example.ecommerce.Repository.Products_Repository;
import com.example.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Product_Service {


    @Autowired
    private Products_Repository productsReposatory;
    private User_Service user_service;

    public Product_Service(Products_Repository productsReposatory) {
        this.productsReposatory = productsReposatory;
    }

    public  String GetAllProducts() {
        productsReposatory.findAll();
        return "Show All Products Successful";

    }
    public String AddProduct(Products product) {
        if (productsReposatory.existsById(product.getId())) {
            return "this product has already been added ";


        }
        else {

            productsReposatory.save(product);
            return "Add Product Successful";

        }


    }
    public String RemoveProduct(Products product) {
        if (productsReposatory.existsById(product.getId())) {

            productsReposatory.delete(product);
            return "Delete Product Success";

        }
        else {


            return "Delete Product is not exist";
        }

    }
    public String RemoveAllProduct() {
        productsReposatory.deleteAll();
        return "Delete All Product Success";

    }
    public void RemoveProductByid(Integer id) {

        productsReposatory.deleteById(id);

    }
    public String  UpdateProduct(Products product) {
        if (productsReposatory.existsById(product.getId())) {

            productsReposatory.save(product);
            return "Update Product Success";

        }
        else {

            return "this product is not found plese add this prodict first ";
        }




    }
    public String findByProduuctsName (String name) {

        String Product = String.valueOf(productsReposatory.findByProduuctsName(name));
        return Product;
    }


    public Products getProductById(Long productId) {
        return productsReposatory.findById(Math.toIntExact(productId))
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }





    public List<Products> getProductsByUserId(Long userId) {
        return productsReposatory.getProductsByUserId(userId);


    }
    }

