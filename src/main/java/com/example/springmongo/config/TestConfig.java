package com.example.springmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.springmongo.domain.Post;
import com.example.springmongo.domain.User;
import com.example.springmongo.dto.AuthorDTO;
import com.example.springmongo.dto.CommentDTO;
import com.example.springmongo.dto.UserDTO;
import com.example.springmongo.repository.PostRepository;
import com.example.springmongo.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Post p1 = new Post(null, Instant.parse("2020-05-06T08:10:07Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
		Post p2 = new Post(null, Instant.parse("2020-05-04T09:10:07Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
		
		p1.getComments().add(new CommentDTO("Aproveite!", Instant.parse("2020-05-06T08:12:07Z"), new UserDTO(u3)));
		p1.getComments().add(new CommentDTO("Boa Viagem mano!", Instant.parse("2020-05-06T10:12:07Z"), new UserDTO(u2)));
		p2.getComments().add(new CommentDTO("Tenha um ótimo dia", Instant.parse("2020-05-05T10:12:07Z"), new UserDTO(u2)));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().add(p1);
		u1.getPosts().add(p2);
		userRepository.save(u1);
		
		
	}

}
