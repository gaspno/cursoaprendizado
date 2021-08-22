package com.teste.curso.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj=service.insert(obj);	
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{Id}")
	public ResponseEntity<Void> delete(@PathVariable Long Id){
		service.dele(Id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="{Id}")
	public ResponseEntity<User> update(@PathVariable Long Id,@RequestBody User obj){
		obj=service.update(Id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
