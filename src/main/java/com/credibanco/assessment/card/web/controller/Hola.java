package com.credibanco.assessment.card.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hola {
	
	@GetMapping("/saludar")
	public String saludar() {
		return "Hola Mundo";
	}

}
