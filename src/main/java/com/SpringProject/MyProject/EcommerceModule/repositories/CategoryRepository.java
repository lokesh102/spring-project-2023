package com.SpringProject.MyProject.EcommerceModule.repositories;

import com.SpringProject.MyProject.EcommerceModule.models.Category;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByName(String name);
    Category findDistinctByName(String name);
    Optional<Category> findById(Long Id);
}
