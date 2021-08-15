package com.teste.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.curso.entities.User;
import com.teste.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list=service.findALL();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{Id}")	
	public ResponseEntity<User> findById(@PathVariable Long Id){
		User u1=service.findById(Id);
		
		return ResponseEntity.ok().body(u1);
		
	}
	
	

}
