package com.project.school.loginmgmt.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.loginmgmt.model.User;
import com.project.school.loginmgmt.service.UserService;

/**
 * @author Vishal
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user.getUserName(), user.getPassword());
	}
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	@GetMapping("getUserById")
	public User getUserById(@PathParam(value = "id") String id) {		
		return userService.getUserById(id);	
	}
	

}
