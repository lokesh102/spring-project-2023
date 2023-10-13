package com.SpringProject.MyProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String category;
    private Double price;
    private String description;
}
