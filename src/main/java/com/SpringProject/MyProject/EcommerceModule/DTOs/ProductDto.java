package com.SpringProject.MyProject.EcommerceModule.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String imageURL;
    private String category;
    private Long categoryId;
}
