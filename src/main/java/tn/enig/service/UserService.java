package tn.enig.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import tn.enig.model.User;

public interface UserService extends UserDetailsService {
	
   User findByUsername(String username);
}
