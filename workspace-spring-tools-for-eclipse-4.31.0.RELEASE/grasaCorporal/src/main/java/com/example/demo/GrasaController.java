package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class GrasaController {
	
	@GetMapping("/")
	public String mostrarFormulario(Usuario usuario) {
		return "form";
	}
	
	@PostMapping("/")
	public String checkUsuarioInfo(@Valid Usuario usuario, BindingResult bindingResult, Model model)  {
		if (bindingResult.hasErrors()) {
            return "form";
	}
		 // Calcular el IMC (Índice de Masa Corporal)
        double imc = usuario.getPeso() / (usuario.getEstatura() * usuario.getEstatura());

        // Aplicar fórmula de Deurenberg
        double porcentajeGrasa = (1.20 * imc) + (0.23 * usuario.getEdad()) - (10.8 * usuario.getGenero()) - 5.4;

        // Clasificar el porcentaje de grasa corporal
        String clasificacion = clasificarGrasa(porcentajeGrasa);

        // Pasar los datos calculados a la vista
        model.addAttribute("porcentajeGrasa", String.format("%.2f", porcentajeGrasa));
        model.addAttribute("clasificacion", clasificacion);

        // Retornar la vista resultado directamente sin redirección
        return "resultado";
    }
	
	// Método para clasificar el porcentaje de grasa corporal
    private String clasificarGrasa(double porcentaje) {
        if (porcentaje < 6) {
            return "Muy bajo";
        } else if (porcentaje < 14) {
            return "Bajo";
        } else if (porcentaje < 18) {
            return "Aceptable";
        } else if (porcentaje < 25) {
            return "Alto";
        } else {
            return "Muy alto";
        }
    }

}
