package com.example.springmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Instant date;
	
	private UserDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String text, Instant date, UserDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}
}
