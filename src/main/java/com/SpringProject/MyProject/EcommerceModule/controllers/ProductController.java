package com.SpringProject.MyProject.EcommerceModule.controllers;
import com.SpringProject.MyProject.EcommerceModule.models.Category;
import com.SpringProject.MyProject.EcommerceModule.services.ProductService;
import com.SpringProject.MyProject.EcommerceModule.models.Product;
import com.SpringProject.MyProject.EcommerceModule.DTOs.ProductDto;
import com.SpringProject.MyProject.clients.AuthenticationClient;
import com.SpringProject.MyProject.clients.DTOs.ValidateResponseDTO;
import com.SpringProject.MyProject.clients.exceptions.UserNotFoundException;
import com.SpringProject.MyProject.clients.models.Role;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
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
    public List<ProductDto> getAllProducts(@RequestHeader(value = "AUTH-HEADER") String token, @RequestHeader(value = "USER-ID") String userId) throws UserNotFoundException, AccessDeniedException {
        AuthenticationClient authenticationClient = new AuthenticationClient();
        ValidateResponseDTO validateResponseDTO = authenticationClient.getAuthentication(token,Long.valueOf(userId));
        if(validateResponseDTO == null){
            throw new UserNotFoundException("user not found");
        }
        boolean isAdmin = false;
        for(Role role:validateResponseDTO.getRoles()){
            if(role.getName().equals("ADMIN")){
                isAdmin = true;
            }
        }
        if(isAdmin){
            List<Product> products = productService.getAllProducts();
            List<ProductDto> productDtoList = new ArrayList<>();
            for(Product product : products){
                ProductDto productDto = convertProductToProductDTO(product);
                productDtoList.add(productDto);
            }
            return productDtoList;
        }
        throw new AccessDeniedException("no Access for this role");
    }
    @GetMapping("/{productId}")
    public ProductDto getSingleProduct(@PathVariable(name = "productId")Long productId){
        Product product = productService.getSingleProduct(productId);
        ProductDto productDto= convertProductToProductDTO(product);
        return productDto;
    }

    @PostMapping()
    public ProductDto addNewProduct(@RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        Product product1 = productService.addNewProduct(product);
        ProductDto productDto1 = convertProductToProductDTO(product1);
        return productDto1;
        //return  product1;
    }
//    @PostMapping()
//    public Product addNewProduct(@RequestBody Product product){
//        //Product product = convertProductDtoToProduct(productDto);
//        Product product1 = productService.addNewProduct(product);
//       // ProductDto productDto1 = convertProductToProductDTO(product1);
//        return product1;
//    }
    @PatchMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable(name = "productId")Long productId, @RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        Product product1 = productService.updateProduct(productId,product);
        ProductDto productDto1 = convertProductToProductDTO(product1);
        return productDto1;
    }
    @PutMapping("/{productId}")
    public ProductDto replaceProduct(@PathVariable(name = "productId")Long productId, @RequestBody ProductDto productDto){
        Product product = convertProductDtoToProduct(productDto);
        Product product1 = productService.updateProduct(productId,product);
        ProductDto productDto1 = convertProductToProductDTO(product1);
        return productDto1;
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(name = "productId")Long productId){
        productService.deleteProduct(productId);
    }

    private ProductDto convertProductToProductDTO(Product product) {
        ProductDto productDto1 = new ProductDto();
        productDto1.setId(product.getId());
        productDto1.setDescription(product.getDescription());
        productDto1.setName(product.getName());
        productDto1.setImageURL(product.getImageURL());
        Category category = product.getCategory();
        productDto1.setCategory(category.getName());
        productDto1.setCategoryId(category.getId());
        return productDto1;
    }
    private Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setImageURL(productDto.getImageURL());
        Category category = new Category();
       // category.setName(productDto.getCategory());
        category.setId(productDto.getCategoryId());
        product.setCategory(category);
       // product.getCategory().setId(productDto.getId());
       // product.getCategory().setId(productDto.getId());
        return product;
    }
//    private ProductDto convertFakeStoreProductDtoToProductDto(FakeStoreProductDto fakeStoreProductDto) {
//        ProductDto productDto = new ProductDto();
//        //productDto.setId(fakeStoreProductDto.getId());
//        productDto.setCategory(fakeStoreProductDto.getCategory());
//        productDto.setTitle(fakeStoreProductDto.getTitle());
//        productDto.setPrice(fakeStoreProductDto.getPrice());
//        productDto.setDescription(fakeStoreProductDto.getDescription());
//        productDto.setImage(fakeStoreProductDto.getImage());
//        return productDto;
//    }


}
