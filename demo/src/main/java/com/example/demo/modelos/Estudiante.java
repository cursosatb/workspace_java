package com.example.demo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Estudiante {

	private String nombre;
	private String apellidos;
	private int edad;
}
