package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class HelloWorldController {

		@RequestMapping("/hello")  
		public String hello()   
		{  
		return "Hello to the Tech World";  
		
		}  
		@RequestMapping("/bye")  
		public String bye()   
		{  
		return "Say Bye to every one";  
		
		}  
  
}  
