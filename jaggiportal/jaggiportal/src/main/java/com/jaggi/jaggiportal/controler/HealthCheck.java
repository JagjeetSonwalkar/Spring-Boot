package com.jaggi.jaggiportal.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
    @GetMapping("/healthcheck")
    public String healthCheck()
    {
        return "Every thing is okay.";
    }
}