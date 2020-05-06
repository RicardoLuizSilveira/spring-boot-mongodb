package com.example.springmongo.resource;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongo.domain.Post;
import com.example.springmongo.dto.PostDTO;
import com.example.springmongo.resource.util.URL;
import com.example.springmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok(new PostDTO(obj));
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String txt) {
		txt = URL.decodeParam(txt);
		List<Post> list = service.findByTitle(txt);
		List<PostDTO> listDto = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<PostDTO>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String txt,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		txt = URL.decodeParam(txt);
		
		Instant min = URL.convertInstant(minDate + "T00:00:00Z", Instant.parse("2000-01-01T00:00:00Z"));
		Instant max = URL.convertInstant(maxDate + "T23:59:59Z", Instant.now());
		List<Post> list = service.fullSearch(txt, min, max);
		List<PostDTO> listDto = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
}









