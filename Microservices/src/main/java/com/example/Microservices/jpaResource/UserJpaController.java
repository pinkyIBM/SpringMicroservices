package com.example.Microservices.jpaResource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.example.Microservices.user.UserNotFoundException;

@RestController
public class UserJpaController {

	@Autowired
	UserRepository us;

	@GetMapping(path = "jpa/users")
	public List<User> getAllUser() {

		return us.findAll();
	}

	@GetMapping(path = "jpa/users/{id}")
	public User helloWorldBean(@PathVariable Integer id) {

		Optional<User> user = us.findById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return null;
	}

	@DeleteMapping(path = "jpa/users/{id}")
	public void deleteById(@PathVariable Integer id) {

		 us.deleteById(id);
		
	}

	@PostMapping("jpa/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User saved = us.save(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(loc).build();
	}
}
