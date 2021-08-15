package com.teste.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	

}
