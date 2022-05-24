package json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// crea un objeto de la clase Gson (inicializa la librería)
//		Gson gson = new Gson();
		
		// crear un objeto de la clase Gson con la opción de conversión con tabulaciones 
		// a String en formato JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// crea un objeto de la clase Persona
		Persona persona = new Persona(25, "Chema", false);
		persona.insertarAficion("baloncesto");
		persona.insertarAficion("ajedrez");
		System.out.println(persona);
		
		// convierte de objeto Java a String en formato JSON
		String personaJSON = gson.toJson(persona);
		System.out.println(personaJSON);
		
		// convierte de String en formato JSON a objeto Java
		Persona persona2 = gson.fromJson(personaJSON, Persona.class);
		System.out.println(persona2);
		
		
	}

}
