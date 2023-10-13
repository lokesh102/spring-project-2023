package com.SpringProject.MyProject.services;

import com.SpringProject.MyProject.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.models.Product;

import java.util.List;

public interface CategoryService {

    List<FakeStoreProductDto> getAllProductsInCategory(String categoryName);

    List<String> getAllCategories();
}
