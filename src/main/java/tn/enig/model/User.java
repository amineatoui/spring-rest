package tn.enig.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	
	@Id
	private int id;
	private String username;
	private String password;
	private boolean enabled;
	
	
	@ManyToOne 
	@JoinColumn(name="role_id")
	private Role role;


	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(role.getRole()));
		// TODO Auto-generated method stub
		System.out.println(role.getRole());
		return auths;
	}





	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}





	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}





	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public Role getRole() {return role;}
	
}
