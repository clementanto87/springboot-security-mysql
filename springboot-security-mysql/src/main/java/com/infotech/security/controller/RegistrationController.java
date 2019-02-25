package com.infotech.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotech.security.model.User;
import com.infotech.security.repository.UserDetailsRepository;

@Controller
public class RegistrationController {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@GetMapping("/signup")
	public String registrationHomePage() {
		return "signup";
	}

	@GetMapping("/register")
	public String signUp(@RequestParam("username") String userName, @RequestParam("psw") String psw) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(psw);

		User user = new User();
		user.setUserName(userName);
		user.setPassword(encode);
		int max = 1;
		User findFirstByOrderByDesc = userDetailsRepository.findFirstByOrderByIdDesc();
		if (findFirstByOrderByDesc != null) {
			max = findFirstByOrderByDesc.getId() + 1;
		}
		user.setId(max);

		userDetailsRepository.save(user);

		return "login";
	}
}
