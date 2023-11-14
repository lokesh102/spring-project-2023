package com.SpringProject.MyProject.EcommerceModule.services;

import com.SpringProject.MyProject.EcommerceModule.DTOs.ProductDto;
import com.SpringProject.MyProject.EcommerceModule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(Product product);

    /*
    Product object has only those fields filled which need to be updated.
    Everything else is null
     */
    Product updateProduct(Long productId, Product product);
    // if (product.getImageUrl() != null) {
    //
    // }
    Product replaceProduct(Long productId, Product product);

    void deleteProduct(Long productId);

}
