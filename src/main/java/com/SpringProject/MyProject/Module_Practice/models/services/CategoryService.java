package com.SpringProject.MyProject.Module_Practice.models.services;

import com.SpringProject.MyProject.Module_Practice.models.dto.FakeStoreProductDto;

import java.util.List;

public interface CategoryService {

    List<FakeStoreProductDto> getAllProductsInCategory(String categoryName);

    List<String> getAllCategories();
}
