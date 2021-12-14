package com.CRudJava.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.xml.ws.Response;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRudJava.app.entity.User;
import com.CRudJava.app.service.UserServiceImple;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImple userService;
	
	//Create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
		
	}
	//Read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long userId ){
		Optional<User> oUser = userService.findbyId(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
	 return ResponseEntity.ok(oUser);
	}
	
	//Update user
	@PutMapping("/{id}")
	
	public  ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
		Optional< User> user = userService.findbyId(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(userDetails, user.get());
		user.get().setName(userDetails.getName());
		user.get().setSurnmae(userDetails.getSurnmae());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEnbable(userDetails.getEnbable());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	//Delete an user
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long userID){
		
		if(!userService.findbyId(userID).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userID);
		
		return ResponseEntity.ok().build();
	}
	
	//Read all users
	@GetMapping
	public List<User> readAll (){
		List<User> users = StreamSupport
				.stream(userService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		
		return users;
				
	}
	
}
