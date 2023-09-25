package com.SpringProject.MyProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "lokesh") String name){
        return "hello " +name;
    }
}
