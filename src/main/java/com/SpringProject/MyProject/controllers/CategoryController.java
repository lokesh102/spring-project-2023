package com.SpringProject.MyProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/products/categories")
    public String getAllCategories(){
        return "All Categories";
    }
    @GetMapping("/products/categories/{categoryId}")
    private String getAllProductsOfSingleCategory(@PathVariable(name = "categoryId") Long categoryId){
        return "products with category id "+categoryId;

    }
}
