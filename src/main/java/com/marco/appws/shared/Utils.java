package com.marco.appws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * This class contains all the util functions needed for the program that needs to be shared across levels
 * @author marco
 *
 */
@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	
	/**
	 * Generate a random user ID of the choosen length
	 * @param length
	 * @return
	 */
	public String generateUserId(int length) {
		
		return generateRandomString(length);
		
	}
	
	/**
	 * Generate a random string of the selected length
	 * @param length
	 * @return
	 */
	private String generateRandomString(int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			//get a random character at the selected random int from the alphabet string and appends it
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}

}
