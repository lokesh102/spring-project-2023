package com.SpringProject.MyProject.Module_Practice.models.services;

import com.SpringProject.MyProject.Module_Practice.models.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.Module_Practice.models.Category;
import com.SpringProject.MyProject.Module_Practice.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductImpl implements ProductService{
    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request,responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String URL = "https://fakestoreapi.com/products";
       // ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity = requestForEntity(URL,HttpMethod.GET,FakeStoreProductDto[].class,null);
        ResponseEntity<FakeStoreProductDto[]> fakeStoreList = restTemplate.getForEntity(URL,FakeStoreProductDto[].class);
        return Arrays.asList(fakeStoreList.getBody());
       //  return Arrays.asList(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public FakeStoreProductDto getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String URL = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity(URL,FakeStoreProductDto.class,productId);
        FakeStoreProductDto response = fakeStoreProductDtoResponseEntity.getBody();
        //Product product = convertFakeStoreProductDtoToProduct(response);
        return response;
    }

    @Override
    public FakeStoreProductDto addNewProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        String URL = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(URL,HttpMethod.POST,fakeStoreProductDto,FakeStoreProductDto.class);
        FakeStoreProductDto response = fakeStoreProductDtoResponseEntity.getBody();
        return response;
    }


    @Override
    public FakeStoreProductDto updateProduct(Long productId,Product product) {
        String URL = "https://fakestoreapi.com/products/{id}";
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(URL,HttpMethod.PATCH,fakeStoreProductDto,FakeStoreProductDto.class,productId);
        FakeStoreProductDto response = fakeStoreProductDtoResponseEntity.getBody();
        return response;
    }

    @Override
    public FakeStoreProductDto replaceProduct(Long productId,Product product) {
        String URL = "https://fakestoreapi.com/products/{id}";
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(URL,HttpMethod.PUT,fakeStoreProductDto,FakeStoreProductDto.class,productId);
        FakeStoreProductDto response = fakeStoreProductDtoResponseEntity.getBody();
        return response;
    }

    private FakeStoreProductDto convertProductToFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        return fakeStoreProductDto;
    }

    @Override
    public FakeStoreProductDto deleteProduct(Long productId) {
        String URL = "https://fakestoreapi.com/products/{id}";
       // FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(URL,HttpMethod.DELETE,null,FakeStoreProductDto.class,productId);
        FakeStoreProductDto response = fakeStoreProductDtoResponseEntity.getBody();
        return response;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto response) {
        Product product = new Product();
        product.setImage(response.getImage());
        product.setPrice(response.getPrice());
        product.setDescription(response.getDescription());
        product.setTitle(response.getTitle());
        Category category = new Category();
        category.setTitle(response.getTitle());
        product.setCategory(category);
        return product;

    }
}
