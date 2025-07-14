package com.jaggi.ganesh; // create the package of the class

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication // it is an annotation and entry point
public class GaneshApplication
{
	@GetMapping("/display")
	public static void main(String[] args)
	{
		SpringApplication.run(GaneshApplication.class, args);
	}
}