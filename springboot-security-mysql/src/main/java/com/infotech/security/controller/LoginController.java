
package com.infotech.security.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Data;


@Controller
public class LoginController {

	@GetMapping("/home")
	//@PreAuthorize("hasAnyRole('USER')") // Role based auth
	 //@Secured("ROLE_ADMIN")
	// @PreAuthorize("hasAuthority('READ_PRIVILEGE')") // priviledge based auth
	public String homePage(HttpServletRequest servletRequest) {
		//Get the user name from the form
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logout-success")
	public String logoutPage() {
		return "login";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}
	
}
