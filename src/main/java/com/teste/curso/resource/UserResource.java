package com.teste.curso.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.curso.entities.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u1=new User(1l,"maria","emailmaria","number125415","senhamaria");
		return ResponseEntity.ok().body(u1);
		
	}
	

}
