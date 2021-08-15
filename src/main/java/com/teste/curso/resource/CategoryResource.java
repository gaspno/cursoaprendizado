package com.teste.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.curso.entities.Category;
import com.teste.curso.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list=service.findALL();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{Id}")	
	public ResponseEntity<Category> findById(@PathVariable Long Id){
		Category u1=service.findById(Id);
		
		return ResponseEntity.ok().body(u1);
		
	}
	
	

}
