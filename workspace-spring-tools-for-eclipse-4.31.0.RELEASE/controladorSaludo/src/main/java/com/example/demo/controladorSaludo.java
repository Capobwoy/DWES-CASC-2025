package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controladorSaludo {

	@GetMapping("/saludo")
	public String saludo(@RequestParam(name="nombre", 
	required=false, defaultValue = "mundo") String name, Model modelo)
	{
		modelo.addAttribute("nombre", name);
		return "saludo";
	}
}
