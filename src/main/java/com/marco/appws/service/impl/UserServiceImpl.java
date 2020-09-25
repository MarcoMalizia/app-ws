package com.marco.appws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marco.appws.UserRepository;
import com.marco.appws.io.entity.UserEntity;
import com.marco.appws.service.UserService;
import com.marco.appws.shared.Utils;
import com.marco.appws.shared.dto.UserDto;


/**
 * The implementation of the UserService, it contains  methods needed for the user controller
 * It uses a repository as dependency to perform crud operations.
 * All end points are protected by spring security.
 * @author marco
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {
		
		
		//query the db to search for a duplicate email, if the email exist it dosen't proceed with the insert
		//more work about handling the exception needed
		if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
			
		//create an entity object and populate it with the data from the dto
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
			
		//encrypt the password given by the user in the request
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		//generate a random user id 
		userEntity.setUserId(utils.generateUserId(30));
			
		//userRepository contains all the default methods from CrudRepository and custom ones
		//store the data from the entity into the db and return an object of the same type
		UserEntity storedUserDetails = userRepository.save(userEntity);
			
		//populate the user dto with the data returned from the db
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
			
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
