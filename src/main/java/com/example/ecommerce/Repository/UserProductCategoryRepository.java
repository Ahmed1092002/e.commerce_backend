package com.example.ecommerce.Repository;

import com.example.ecommerce.model.UserProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductCategoryRepository extends JpaRepository<UserProductCategory, Long> {
}
