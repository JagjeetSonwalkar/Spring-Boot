package com.jaggi.jaggiportalfullstackCompleteEntity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
    @GetMapping("/healthcheck")
    public String healthCheck()
    {
        return "Every Thing looks Okay...";
    }
}
