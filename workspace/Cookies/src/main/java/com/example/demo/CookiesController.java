package com.example.demo;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class CookiesController {
	
	@GetMapping("/logiin")
	public String login(@CookieValue(value = "token", required = false) String token, HttpServletResponse respuesta) {
		if (token != null) {
			return "Ya has iniciado sesión";
		}
		Cookie cookie = new Cookie("token", "tuTokenAleatorio");
		cookie.setMaxAge(3600); //1 hora
		cookie.setSecure(true); //usa HTTPS en produccion
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		respuesta.addCookie(cookie);
		return "Inicio de sesión con éxito";
		
	}

}
