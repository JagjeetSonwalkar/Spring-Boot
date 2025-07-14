package com.jaggi.ganesh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Display // class
{
    @GetMapping("/display")
    public String display() // behaviour
    {
        return "Jay Ganesh...";
    }
}