//package com.example.ecommerce.Repository;
//
//import com.example.ecommerce.model.Permission;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import java.util.Optional;
//
//@Repository
//public interface PermissionRepository extends JpaRepository<Permission, Long> {
//    @Query(value = "select name from Permission name where 'name'=:name")
//    Optional<Permission> findByName(@Param("name") String name);
//}