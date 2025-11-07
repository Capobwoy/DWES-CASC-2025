package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formularioController {
	
	@GetMapping("/")
	public String mostrarFormulario() {
		return "form";
	}
	
	@PostMapping("/form1")
	public String form1(@RequestParam String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		return "form1";
	}
	
	@PostMapping("/form2")
	public String form2() {
		
		return "form2";
	}

}
