package com.SpringProject.MyProject.EcommerceModule.services;

import com.SpringProject.MyProject.EcommerceModule.DTOs.ProductDto;
import com.SpringProject.MyProject.EcommerceModule.models.Category;
import com.SpringProject.MyProject.EcommerceModule.repositories.CategoryRepository;
import com.SpringProject.MyProject.EcommerceModule.repositories.ProductRepository;
import com.SpringProject.MyProject.EcommerceModule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()){
            return null;
        }
        return product.get();
    }

    @Override
    public Product addNewProduct(Product product) {
        //Category category = categoryRepository.findDistinctByName(product.getCategory().getName());
       // product.getCategory().setId(category.getId());
         Long id = product.getCategory().getId();
        if(id == null){
            Product product1 = new Product();
            product1.setName("cannot add the product");
            return product1;
        }
        Optional<Category> category = categoryRepository.findById(id);
        //Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
//        if(category.isPresent()){
//            product.setCategory(category.get());
//        }
        if(category != null){
            Category category1 = category.get();
            product.setCategory(category1);
        }
        Product product1 =  productRepository.save(product);
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Category> category1 = categoryRepository.findById(product.getCategory().getId());
        if(category1.isPresent()){
            product.setCategory(category1.get());
        }
        //Optional<Product> product2 = productRepository.findById(productId);
       // if(product2.isPresent()){
            Product product1 =  productRepository.save(product);
            return product1;
        //}
        //return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        Optional<Category> category1 = categoryRepository.findById(product.getCategory().getId());
        if(category1.isPresent()){
            product.setCategory(category1.get());
        }
        //Optional<Product> product2 = productRepository.findById(productId);
        // if(product2.isPresent()){
        Product product1 =  productRepository.save(product);
        return product1;
        //}
        //return null;
    }
    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
