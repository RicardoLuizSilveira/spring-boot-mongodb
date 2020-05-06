package com.example.springmongo.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmongo.domain.Post;
import com.example.springmongo.repository.PostRepository;
import com.example.springmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository; 
	
	public Post findById(String id) {
		Optional<Post> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String txt) {
		return repository.searchByTitle(txt);
	}
	
	public List<Post> fullSearch(String txt, Instant minDate, Instant maxDate) {
		return repository.fullSearch(txt, minDate, maxDate);
	}
}
