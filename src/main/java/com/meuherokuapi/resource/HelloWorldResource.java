package com.meuherokuapi.resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@GetMapping("/")
	public String index(Model model) {
		return "Hello World!";
		
	}

}
