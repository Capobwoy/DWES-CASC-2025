package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {
	
	static private final String USUARIO = "Cristian";
	static private final String PASSWD ="1234";
	
	@GetMapping("/")
	public String inicio() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("usuario") String usuario,
						@RequestParam("contrasenha") String contrasenha,
						HttpSession session, Model model) {
		if (usuario!=null && usuario.equals(USUARIO) && 
				contrasenha!=null && contrasenha.equals(PASSWD)) {
			session.setAttribute("usuario", usuario);
			model.addAttribute("usuario", usuario);
			return "layout";
		}
		
		
		model.addAttribute("error", "usuario o contraseña incorrectos");
		return "login";
	}
	
	@GetMapping("/pagina1")
	public String pagina1(HttpSession session, Model model) {
		if(session.getAttribute("usuario") == null) {
			model.addAttribute("error", "Debes iniciar sesión para acceder a esta página");
			return "login";
		}
		return "pagina1";
	}
	
	@GetMapping("/pagina2")
	public String pagina2(HttpSession session, Model model) {
		if(session.getAttribute("usuario") == null) {
			model.addAttribute("error", "Debes iniciar sesión para acceder a esta página");
			return "login";
		}
		return "pagina2";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
	    String usuario = (String) session.getAttribute("usuario"); // guarda el nombre antes de borrar
		session.invalidate(); //elimina la sesión
		model.addAttribute("usuario", usuario);
		return "redirect:/"; //volvemos al login
	}

}
