package com.example.demo.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Estudiante;

// anotación para crear un servicio web
@RestController
// la url de esta servicio web comenzará con http://localhost:8081/rest
@RequestMapping("/rest")
public class DemoRest {

	// la url de este método del servicio será http://localhost:8081/rest/estudiantes (GET)
	@GetMapping("/estudiantes/{id}")
	// lo que devuelve el método es lo que se envía al cliente
	public String estudiantes(@PathVariable int id) {
		System.out.println(id);
		return "";
	}
	
	// la url de este método del servicio será http://localhost:8081/rest/insertarEstudiante (POST)
	/*
	 * 
	 * 
	 * {
	    "nombre": "Marco",
	    "apellidos": "Aurelio",
	    "edad": 33
	}
	 */
	@PostMapping("/insertarEstudiante")
	public String insertarEstudiante(
			@RequestBody Estudiante estudiante,
			@RequestHeader("Authorization") String authorization) {
		
		System.out.println(estudiante);
		System.out.println(authorization);
		return "insertar";
	}
	
	@GetMapping("/estudianteJSON")
	public Estudiante estudianteJSON() {
		Estudiante estudiante = new Estudiante("Marco", "Rodolfo", 55);
		return estudiante;
	}
	
	@GetMapping("/estudiantesJSON")
	public ArrayList<Estudiante> estudiantesJSON() {
		
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		for(int i=0; i<3; i++) {
			Estudiante estudiante1 = new Estudiante("Marco", "Rodolfo", i);
			estudiantes.add(estudiante1);
		}
		
		return estudiantes;
	}
	
}
