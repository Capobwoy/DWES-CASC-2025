package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Usuario {

    @NotNull(message = "El peso es obligatorio")
    @Min(value = 1, message = "El peso debe ser mayor que 0")
    private Double peso;

    @NotNull(message = "La estatura es obligatoria")
    @Min(value = 1, message = "La estatura debe ser mayor que 0")
    private Double estatura;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 1, message = "La edad debe ser mayor que 0")
    private Integer edad;

    @NotNull(message = "El género es obligatorio")
    private Integer genero; // 1 = Hombre, 2 = Mujer

    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura != null ? estatura : 0.0;
    }
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getGenero() {
        return genero;
    }
    public void setGenero(Integer genero) {
        this.genero = genero;
    }
}
