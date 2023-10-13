package com.SpringProject.MyProject.services;

import com.SpringProject.MyProject.dto.FakeStoreProductDto;
import com.SpringProject.MyProject.models.Product;
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
public class FakeStoreCategoryImpl implements CategoryService{
    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreCategoryImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request,responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public List<FakeStoreProductDto> getAllProductsInCategory(String categoryName) {
        RestTemplate rs = restTemplateBuilder.build();
        String URl = "https://fakestoreapi.com/products/category/{id}";
        ResponseEntity<FakeStoreProductDto[]> fakeStoreList = rs.getForEntity(URl,FakeStoreProductDto[].class,categoryName);
        return Arrays.asList(fakeStoreList.getBody());
        //return null;
    }

    @Override
    public List<String> getAllCategories() {
        RestTemplate rs = restTemplateBuilder.build();
        String URl = "https://fakestoreapi.com/products/categories";
        ResponseEntity<String[]> categoryList = rs.getForEntity(URl,String[].class);
        //ResponseEntity<String[]> categoryList = requestForEntity(URl,HttpMethod.GET,String[].class,null);
        return Arrays.asList(categoryList.getBody());
    }
}
