package com.example.demo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PruebaController {
	
	@GetMapping("/")
	public String mostrarFormulario() {
		return "formulario";
	}
	
	@GetMapping("/procesarGet")
	public String procesarGet(@RequestParam("texto") String texto, Model model) {
		model.addAttribute("metodo", "GET");
		model.addAttribute("textoRecibido", texto);
		model.addAttribute("textoCodificado", URLEncoder.encode(texto, StandardCharsets.UTF_8));
		return "resultado";
	}
	
	@PostMapping("/procesarPost")
	public String procesarPost(@RequestParam("texto") String texto, Model model) {
		model.addAttribute("metodo", "POST");
		model.addAttribute("textoRecibido", texto);
		return "resultado";
	}

}
