package com.teste.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.curso.entities.Product;
import com.teste.curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")

public class ProductResource {
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list=service.findALL();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{Id}")	
	public ResponseEntity<Product> findById(@PathVariable Long Id){
		Product u1=service.findById(Id);
		
		return ResponseEntity.ok().body(u1);
		
	}
	
	

}
