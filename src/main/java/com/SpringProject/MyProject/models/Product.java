package com.SpringProject.MyProject.models;

import lombok.Getter;
import lombok.Setter;

import javax.xml.transform.sax.SAXResult;
@Getter
@Setter
public class Product {
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;


}
