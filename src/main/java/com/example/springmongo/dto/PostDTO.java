package com.example.springmongo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.example.springmongo.domain.Post;

public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Instant date;
	private String title;
	private String body;
	
	private AuthorDTO author;
	private List<CommentDTO> comments = new ArrayList<>();
	
	public PostDTO() {
	}

	public PostDTO(Post obj) {
		super();
		this.id = obj.getId();
		this.date = obj.getDate();
		this.title = obj.getTitle();
		this.body = obj.getBody();
		this.author = obj.getAuthor();
		this.comments = obj.getComments();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}
}
