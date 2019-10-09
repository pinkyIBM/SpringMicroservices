package com.example.Microservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	
	@GetMapping(path="/helloWorld")
	public String helloWorld() 
	{
		return "Hello World";
	}
   
	@GetMapping(path="/helloWorldBean")
	public HelloWorldBean helloWorldBean() 
	{
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/helloWorldBean/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) 
	{
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
}
