package com.SpringProject.MyProject.Module_Practice.models.controllers;

import com.SpringProject.MyProject.Module_Practice.models.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.Module_Practice.models.dto.ProductDto;
import com.SpringProject.MyProject.Module_Practice.models.Category;
import com.SpringProject.MyProject.Module_Practice.models.Product;
import com.SpringProject.MyProject.Module_Practice.models.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public List<ProductDto> getAllProducts(){
        List<ProductDto> products = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = productService.getAllProducts();
        for(FakeStoreProductDto res : fakeStoreProductDtos){
            ProductDto productdto = convertFakeStoreProductDtoToProductDto(res);
            products.add(productdto);
        }
        return products;
    }
    @GetMapping("/{productId}")
    public ProductDto getSingleProduct(@PathVariable(name = "productId")Long productId){
       // Product product = productService.getSingleProduct(productId);
        FakeStoreProductDto fakeStoreProductDto = productService.getSingleProduct(productId);
        ProductDto productDto =  convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
        return productDto;
    }

    @PostMapping()
    public ProductDto addNewProduct(@RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        FakeStoreProductDto fakeStoreProductDto = productService.addNewProduct(product);
        ProductDto productDto1 = convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
        return productDto1;
    }
    @PatchMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable(name = "productId")Long productId, @RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        FakeStoreProductDto fakeStoreProductDto = productService.updateProduct(productId,product);
        ProductDto productDto1 = convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
        return productDto1;
    }
    @PutMapping("/{productId}")
    public ProductDto replaceProduct(@PathVariable(name = "productId")Long productId, @RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        FakeStoreProductDto fakeStoreProductDto = productService.replaceProduct(productId,product);
        ProductDto productDto1 = convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
        return productDto1;
    }
    @DeleteMapping("/{productId}")
    public ProductDto deleteProduct(@PathVariable(name = "productId")Long productId){
        // Product product = convertProductDtoToProduct(productDto);
        FakeStoreProductDto fakeStoreProductDto = productService.deleteProduct(productId);
        ProductDto productDto1 = convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
        return productDto1;
    }

    private Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setImage(productDto.getImage());
        Category category = new Category();
        category.setTitle(productDto.getTitle());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        return product;
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
