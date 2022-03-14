package com.gp.pai_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "accessFault";
	}
}