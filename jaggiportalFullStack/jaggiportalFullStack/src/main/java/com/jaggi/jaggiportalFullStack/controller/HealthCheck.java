package com.jaggi.jaggiportalFullStack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
    @GetMapping("/healthcheck")
    public String healthCheck()
    {
        String sData = "Every thing look okay...";
        return sData;
    }
}
