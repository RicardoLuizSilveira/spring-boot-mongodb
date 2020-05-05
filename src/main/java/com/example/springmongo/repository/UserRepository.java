package com.example.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
