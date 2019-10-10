package com.example.Microservices.filtering;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservices.filtering.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;;

@RestController
public class FilteringConroller {

	
	
	
	@GetMapping(path="/staticfiltering")
	public User getAllUser() 
	{
		
		return new User(1,"pinky",new Date());
	}
	
	@GetMapping(path="/dynamicfiltering")
	public MappingJacksonValue getUser() 
	{
		User u =  new User(1,"pinky",new Date());
		SimpleBeanPropertyFilter fil = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider f = new SimpleFilterProvider().addFilter("UserFilter", fil);
		
		MappingJacksonValue map = new MappingJacksonValue(u);
		map.setFilters(f);
		return map;
	}
}
