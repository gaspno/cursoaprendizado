package com.teste.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
