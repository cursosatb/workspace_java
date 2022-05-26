import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Agenda {

	private HashMap<String, Contacto> contactos;
	
	public Agenda() {
		this.contactos = new HashMap<String, Contacto>();
//		this.leerEnDisco();
	}
	
	@Override
	public String toString() {
		return "Agenda [contactos=" + contactos + "]";
	}

	public boolean agregarContacto(Contacto nuevoContacto) {
		
		// extraemos el nombre del nuevo contacto que queremos agregar
		String nombre = nuevoContacto.getNombre();
		
		// si el nombre del nuevo contacto ya existe en los contactos
		if(this.contactos.containsKey(nombre)) {
			return false;
		}
	
		// si estamos aquí, entonces el nombre del nuevo contacto no existe
		// en los contactos y hay que agregarlo
		this.contactos.put(nombre, nuevoContacto);
		
		this.escribirEnDisco();
		
		return true;
	}
	
	public boolean eliminarContacto(String nombre) {
		
		// si el nombre del nuevo contacto NO existe en los contactos
		if(!this.contactos.containsKey(nombre)) {
			return false;
		}
		
		// elimina el contacto de el HashMap de contactos
		this.contactos.remove(nombre);
		
		this.escribirEnDisco();
		
		return true;
	}
	
	public boolean existeContacto(String nombre) {
		return this.contactos.containsKey(nombre);
	}
	
	public void listarContactos() {
		
		// iterar los contactos (HashMap) mediante un forEach
		for(String nombre : this.contactos.keySet()) {
			// extraer el contacto a partir del nombre del contacto
			this.contactos.get(nombre).mostrarInfo();
		}
	}
	
	// si existe el contacto, retornamos el contacto y si no, null
	public Contacto buscarContacto(String nombre) {
		return (this.contactos.containsKey(nombre)) ?
				this.contactos.get(nombre) : null;
	}

	public void listarContactosAlfabeticamente() {

		ArrayList<String> nombres = new ArrayList<>(this.contactos.keySet());
		Collections.sort(nombres);
		
		for (String nombre : nombres) {
			System.out.println(nombre 
					+ " tiene el teléfono " 
					+ this.contactos.get(nombre).getTelefono());
		}
		
	}
	
	public void leerEnDisco() {
		
		try {
			String contenidoJSON = new String ( Files.readAllBytes( Paths.get("agenda.json") ) );
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			System.out.println(contenidoJSON);
			Agenda agenda = gson.fromJson(contenidoJSON, Agenda.class);
			this.contactos = agenda.getContactos();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
	
	private void escribirEnDisco() {
		
		// inicialización de la librería gson
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// conversión objeto Java (Agenda) a string en formato JSON
		String contenidoJSON = gson.toJson(this);
		
		try {
			FileWriter fileWriter = new FileWriter("agenda.json");
			fileWriter.write(contenidoJSON);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public HashMap<String, Contacto> getContactos() {
		return contactos;
	}

	
	
}
