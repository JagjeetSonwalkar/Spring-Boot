package com.jaggi.firstendpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Laptop
{
    @GetMapping("/laptopdetails")
    public String displayLaptopDetails()
    {
        return "It's Core i7 2nd Gen Laptop";
    }
}

// Laptop obj = new Laptop();
// obj.displayLaptopDetails();

// this object creation is not needed in spring boot
// bean : object of class