package com.arjun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arjun.model.NotValid;
import com.arjun.model.User;
import com.arjun.model.UserLogin;
import com.arjun.repository.UserRepository;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

	
	
	@Autowired
	private  UserRepository userservice;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginuser(@RequestBody UserLogin userlogin) throws NotValid{
		
		User user=userservice.loginuser(userlogin.getUsername(),userlogin.getPassword());
		//userservice.findByUsernamePassword(userlogin);	
		
		if(user == null) {
//			throw new NotValid("Not Valid");
//			ResponseEntityExceptionHandler("user not found");
			return ResponseEntity.ofNullable("not found");
			
		}
		
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userservice.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userservice.findById(id)
				.orElseThrow();
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return userservice.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deletUser(@PathVariable int id) {
		userservice.deleteById(id);
	}
	
	 @PutMapping("/{id}")
	    public User updateUser(@PathVariable int id, @RequestBody User user) {
		 User ExistingUser=userservice.findById(id)
					.orElseThrow(()-> new EntityNotFoundException("User Not Found with id : "+id));
			
			ExistingUser.setUsername(user.getUsername());
			ExistingUser.setPassword(user.getPassword());
			ExistingUser.setCity(user.getCity());
			ExistingUser.setGmail(user.getGmail());
			return ExistingUser;
	    }
	
	
}
