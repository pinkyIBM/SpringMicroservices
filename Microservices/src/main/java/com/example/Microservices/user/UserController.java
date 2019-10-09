package com.example.Microservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {

	@Autowired
	UserDaoService us;
	
	@GetMapping(path="/users")
	public List<User> getAllUser() 
	{
		
		return  us.findAll();
	}
   
	
	
	@GetMapping(path="/users/{id}")
	public User helloWorldBean(@PathVariable Integer id) 
	{
		
		User user =  us.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id-"+id);
		
		return null;
	}
	

	@DeleteMapping(path="/users/{id}")
	public User deleteById(@PathVariable Integer id) 
	{
		
		User user =  us.delete(id);
		if(user == null)
			throw new UserNotFoundException("id-"+id);
		return null;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) 
	{
		User saved = us.save(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(loc).build();
	}
}
