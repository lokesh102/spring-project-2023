package com.SpringProject.MyProject.controllers;

import com.SpringProject.MyProject.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.dto.ProductDto;
import com.SpringProject.MyProject.services.CategoryService;
import com.SpringProject.MyProject.services.FakeStoreCategoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        List<String> categoryList = categoryService.getAllCategories();
        return categoryList;
    }
    @GetMapping("/category/{categoryId}")
    private List<ProductDto> getAllProductsOfSingleCategory(@PathVariable(name = "categoryId") String categoryId){
        List<FakeStoreProductDto> fakeStoreProductDtoList = categoryService.getAllProductsInCategory(categoryId);
        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fs : fakeStoreProductDtoList){
            ProductDto productDto = convertFakeStoreProductDtoToProductDto(fs);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
    private ProductDto convertFakeStoreProductDtoToProductDto(FakeStoreProductDto fakeStoreProductDto) {
        ProductDto productDto = new ProductDto();
        //productDto.setId(fakeStoreProductDto.getId());
        productDto.setCategory(fakeStoreProductDto.getCategory());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice());
        productDto.setDescription(fakeStoreProductDto.getDescription());
        productDto.setImage(fakeStoreProductDto.getImage());
        return productDto;
    }
}
