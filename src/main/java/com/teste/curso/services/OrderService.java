package com.teste.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.curso.entities.Order;
import com.teste.curso.repositories.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findALL(){
		
		
		return repository.findAll();
		
	}
	public Order findById(Long Id) {
		
		Optional<Order> obj=repository.findById(Id);
		return obj.get();
		
		
	}
}
