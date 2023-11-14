package com.SpringProject.MyProject.EcommerceModule.repositories;
import com.SpringProject.MyProject.EcommerceModule.DTOs.ProductDto;
import com.SpringProject.MyProject.EcommerceModule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
     Product save(Product product);
     Optional<Product> findById(Long Id);
     List<Product> findAll();
     Product removeById(Long id);
}
