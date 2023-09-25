package com.SpringProject.MyProject.controllers;

import com.SpringProject.MyProject.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/products")
    public String getAllProducts(){
        return "All products";
    }
    @GetMapping("/products/{productId}")
    public String getSingleProduct(@PathVariable(name = "productId")Long productId){
        return "single product with id "+productId;
    }
    @PostMapping("/products")
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "added new product "+productDto.getTitle();
    }
    @PutMapping("/products/{productId}")
    public String updateProduct(@PathVariable(name = "productId")Long productId, @RequestBody ProductDto productDto){
        return "updated product with id "+productId;
    }
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable(name = "productId")Long productId){
        return "deleted product with id "+productId;
    }
}
