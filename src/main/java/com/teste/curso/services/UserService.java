package com.teste.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.curso.entities.User;
import com.teste.curso.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findALL(){
		
		
		return repository.findAll();
		
	}
	public User findById(Long Id) {
		
		Optional<User> obj=repository.findById(Id);
		return obj.get();
		
		
	}
}
