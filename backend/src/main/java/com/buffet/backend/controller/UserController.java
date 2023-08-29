package com.buffet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buffet.backend.model.User;
import com.buffet.backend.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	private UserService userService;
	
	//helloWorld
	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
	
	//Rest API - CRUD
	//Create(read) User - POST
	//Read(listar) USer - GET
	//Delete user - DELETE
	//Update User - PUT
	
	//create User
	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		User user1 = userService.createUser(user);
		return user1;
	}
	
	//Read(listar)
	@GetMapping("/users")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	//update- Put
	@PutMapping("/update/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") long id) {
		return userService.updateUser(user, id);
	}
	
	//Delete user by id
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "Apagado com Sucesso";
	}
	
	//get User by id
	@GetMapping("/user/{id}")
	public User getById(@PathVariable("id") long id) {

	return userService.getUserById(id);
	}	
}
