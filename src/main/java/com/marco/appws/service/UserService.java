package com.marco.appws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.marco.appws.shared.dto.UserDto;
/**
 * The user service interface mapping all the methods required for the user controller
 * @author marco
 *
 */
public interface UserService extends UserDetailsService{
	

	UserDto createUser(UserDto user);

}
