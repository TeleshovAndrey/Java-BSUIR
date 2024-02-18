package com.springbool.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		return "{ " + "name: " + name + ", " + "surname: " + surname + " }";
	}
	
	
}
