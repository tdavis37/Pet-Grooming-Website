package com.petgrooming;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	 User save(UserRegistrationDto registrationDto);
}
