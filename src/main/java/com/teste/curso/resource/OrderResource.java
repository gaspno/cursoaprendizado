package com.teste.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.curso.entities.Order;
import com.teste.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")

public class OrderResource {
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list=service.findALL();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{Id}")	
	public ResponseEntity<Order> findById(@PathVariable Long Id){
		Order u1=service.findById(Id);
		
		return ResponseEntity.ok().body(u1);
		
	}
	
	

}
