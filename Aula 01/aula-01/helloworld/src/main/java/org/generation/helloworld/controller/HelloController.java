package org.generation.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Indica para o Spring que esta é uma classe Controladora
@RequestMapping("/Hello") // Indica um End Point para a aplicação


public class HelloController {
	
	@GetMapping
	public String helloWorld() {
		return "Alô, mundão!";
	}
	
	@GetMapping("/bsm")
	public String bsm() {
		return "Atenção aos detalhes!";
	}
	
}
