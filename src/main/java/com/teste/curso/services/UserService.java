package com.teste.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.teste.curso.entities.User;
import com.teste.curso.repositories.UserRepository;
import com.teste.curso.services.exceptions.DatabaseException;
import com.teste.curso.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findALL(){
		
		
		return repository.findAll();
		
	}
	public User findById(Long Id) {
		
		Optional<User> obj=repository.findById(Id);
		return obj.orElseThrow(()->new ResourceNotFoundException(Id));
		
		
	}
	public User insert(User user) {
		return repository.save(user);
	}
	public void dele(Long Id) {
		try {
		repository.deleteById(Id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(Id);			
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());			
		}
	}
	public User update(Long Id,User user) {
		try {
		User entity=repository.getOne(Id);
		UpdateDate(entity,user);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(Id);
			
		}
		
	}
	private void UpdateDate(User entity, User user) {
		// TODO Auto-generated method stub
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
}
