package com.example.Microservices.versioning;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersioningController {

	
	@GetMapping(path="/v1/person")
	public PersonV1 getPersonv1() 
	{
		
		return new PersonV1("Pinky Mittal");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getPersonv2() 
	{
		
		return new PersonV2(new Name("Pinky","Mittal"));
	}
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 paramv1() 
	{
		
		return new PersonV1("Pinky Mittal");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramv2() 
	{
		
		return new PersonV2(new Name("Pinky","Mittal"));
	}
	@GetMapping(value="/person/header",headers="X-api-version=1")
	public PersonV1 headerv1() 
	{
		
		return new PersonV1("Pinky Mittal");
	}
	
	@GetMapping(value="/person/header",headers="X-api-version=2")
	public PersonV2 headerv2() 
	{
		
		return new PersonV2(new Name("Pinky","Mittal"));
	}
}
