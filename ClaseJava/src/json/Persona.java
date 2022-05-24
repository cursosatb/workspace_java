package json;

import java.util.ArrayList;

public class Persona {

	private int edad;
	private String nombre;
	private ArrayList<String> aficiones;
	private boolean funcionario;	
	private Direccion direccion;
	
	public Persona(int edad, String nombre, boolean funcionario) {
		this.edad = edad;
		this.nombre = nombre;
		this.aficiones = new ArrayList<String>();
		this.funcionario = funcionario;
		this.direccion = new Direccion("Castilla", 26);
	}
	
	public void insertarAficion(String aficion) {
		this.aficiones.add(aficion);
	}	

	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", nombre=" + nombre + ", aficiones=" + aficiones + "]";
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getAficiones() {
		return aficiones;
	}		
	
	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}

