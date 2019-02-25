package com.infotech.security.controller;

import javax.annotation.security.PermitAll;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user")
	public String userPage() {
		return "user";
	}
	
	
	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/adminanduser")
	public String adminAndUserPage() {
		return "adminanduser";
	}

}
