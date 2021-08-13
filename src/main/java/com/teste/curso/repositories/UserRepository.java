package com.teste.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
