package com.SpringProject.MyProject.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private String title;
    private String description;
    private List<Product> products;
}
