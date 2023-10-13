package com.SpringProject.MyProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String title;
    private String image;
    private String category;
    private Double price;
    private String description;
}
