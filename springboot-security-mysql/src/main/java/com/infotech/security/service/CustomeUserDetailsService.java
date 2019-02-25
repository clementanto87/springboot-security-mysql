package com.infotech.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infotech.security.model.User;
import com.infotech.security.repository.UserDetailsRepository;

@Service(value = "userService")
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetails Services");
		User user = userDao.findByUserName(username);
		System.err.println(user);
		if (user == null) {  
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		// Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		// authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		// return new com.devglan.model.UserPrinciple(user);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		});
		return authorities;
	}
}