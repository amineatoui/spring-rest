package tn.enig.config;

import javax.activation.DataSource;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.ProviderManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.enig.service.UserService;

@Configuration
@EnableWebSecurity
public class Securityconfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	javax.sql.DataSource dataSource;
	
	@Autowired
	UserService userService;
	//for authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
	
		/*
		PasswordEncoder crypt=cryptageMP();
		try {
			auth.inMemoryAuthentication().withUser("adminGcr")
			.password(crypt.encode("gcr"))
			.roles("ADMIN");
			
			auth.inMemoryAuthentication().withUser("hazem")
			.password(crypt.encode("gcr"))
			.roles("AGENT");
			
			auth.inMemoryAuthentication().withUser("amine")
			.password(crypt.encode("gcr"))
			.roles("AGENT");
			
			auth.inMemoryAuthentication().withUser("hamma")
			.password(crypt.encode("gcr"))
			.roles("AGENT");
			
			auth.inMemoryAuthentication().withUser("ali1")
			.password(crypt.encode("gcr"))
			.roles("USER");
			
			auth.inMemoryAuthentication().withUser("ali2")
			.password(crypt.encode("gcr"))
			.roles("USER");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}*/
		
		
		
		
		PasswordEncoder crypt=cryptageMP();
		
		/*
		try {
			 auth
	            .jdbcAuthentication()
	            .dataSource(dataSource)
	            .passwordEncoder(crypt)
	            .usersByUsernameQuery(
	                "SELECT username, password,1 from users where username = ?")
	            .authoritiesByUsernameQuery(
	                "SELECT u.username, a.authority " +
	                "FROM user_authorities a, users u " +
	                "WHERE u.username = ? " +
	                "AND u.id = a.user_id"
	            )
	            ;
			 
;			

		} 
		 catch (BadCredentialsException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
				
				
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		try {
			auth.userDetailsService(userService).passwordEncoder(crypt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//for authorisation
	@Override
	protected void configure(HttpSecurity http) {
		
		try {
			
			http.formLogin();
			http.authorizeRequests().antMatchers("/delete**").hasRole("ADMIN");
       
       	    http.authorizeRequests().antMatchers("/list**","/add**").hasAnyRole("AGENT","ADMIN");
        
    	    http.authorizeRequests().antMatchers("/listdepartement**").authenticated();
    
    	    http.authorizeRequests().antMatchers("/rest/**").permitAll();
    	
    	    http.exceptionHandling().accessDeniedPage("/accessDenied.jsp");

    	    http.cors().disable();
    	    http.csrf().disable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	//for hashing
	@Bean
	public PasswordEncoder cryptageMP() {
		System.out.println(new BCryptPasswordEncoder().encode(("gcr")));
           return new BCryptPasswordEncoder();		
	}
}
