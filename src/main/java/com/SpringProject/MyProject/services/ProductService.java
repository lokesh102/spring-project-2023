package com.SpringProject.MyProject.services;

import com.SpringProject.MyProject.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.models.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductDto> getAllProducts();
    FakeStoreProductDto getSingleProduct(Long productId);
    FakeStoreProductDto addNewProduct(Product product);

    FakeStoreProductDto updateProduct(Long productId,Product product);

    FakeStoreProductDto replaceProduct(Long productId,Product product);
    FakeStoreProductDto deleteProduct(Long productId);
}
