package com.marco.appws.security;

public class SecurityConstants {
	
	//THE CONSTANTS WILL NEED TO BE MOVED TO A PROPERTY FILE !!!!!
	
	//json web token expiration time = 10 days
	public static final long EXPIRATION_TIME = 864000000;
	public static final String TOKEN_PREFIX = "Bearer: ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";

}
