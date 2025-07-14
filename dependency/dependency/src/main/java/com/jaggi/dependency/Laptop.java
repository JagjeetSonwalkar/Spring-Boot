package com.jaggi.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Laptop
{
    @Autowired
    Hardisk hobj ;

    @Autowired
    RAM robj ;

    @GetMapping("/laptop")
    public String laptopInformation()
    {
        String h = hobj.getHardisk() ;
        String r = robj.getRAM() ;

        String data = "laptop configuration " + h +" & "+ r ;

//      return "It is a laptop having __ configuration";
        return data ;
    }
}
