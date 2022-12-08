package tn.enig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.enig.dao.IUserDao;
import tn.enig.model.User;

@Service
public class UserServiceImp implements UserService {
 
	@Autowired IUserDao userdao;
	
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u =userdao.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("username not found");
		}
		System.out.println(u.getRole().getRole());
		return u;
	}

	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

}
