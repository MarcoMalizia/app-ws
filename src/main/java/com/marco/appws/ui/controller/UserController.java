package com.marco.appws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.appws.service.UserService;
import com.marco.appws.shared.dto.UserDto;
import com.marco.appws.ui.model.request.UserDetailsRequestModel;
import com.marco.appws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "get user was called";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		//create the "safe vesion" user to return
		UserRest returnValue = new UserRest();
		
		//create the data transfer object for the user
		UserDto userDto = new UserDto();
		//populate the DTO with the properties coming from the request
		BeanUtils.copyProperties(userDetails, userDto);
		
		//userService generate some additional values at service level, insert the user into the db and it pass them back at a DTO 
		UserDto createdUser = userService.createUser(userDto);
		//populate the safe version of user to return
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
		
	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user wa called";
	}
}
