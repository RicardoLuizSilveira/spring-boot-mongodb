package com.example.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmongo.domain.User;
import com.example.springmongo.dto.UserDTO;
import com.example.springmongo.repository.UserRepository;
import com.example.springmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}






