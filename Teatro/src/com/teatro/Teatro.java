package com.teatro;

import java.util.ArrayList;

public class Teatro {

	protected String nombre;
	protected String calle;
	protected int superficie;
	protected int accesos;
//	protected HashMap<String, Localidad> localidades;
	protected ArrayList<Localidad> localidades;
	
	public Teatro(String nombre, String calle, int superficie, int accesos) {
		this.nombre = nombre;
		this.calle = calle;
		this.superficie = superficie;
		this.accesos = accesos;


		// inicialización de localidades
		this.localidades = new ArrayList<Localidad>();
		
		// inserta 50 localidades (5 filas x 10 butacas) en el ArrayList
		for(int fila=0; fila<5; fila++) {			
			for(int butaca=0; butaca<10; butaca++) {
				Localidad localidad = new Localidad(false, fila, butaca, null, 0, null, 0.0);			
				this.localidades.add(localidad);
			}			
		}		
	}
	
	public ArrayList<Localidad> getLocalidades() {
		return localidades;
	}

	public void mostrarTeatro() {
		System.out.println("En C/ " + this.calle 
				+ ", local de " + this.superficie
				+ " metros, con " + this.accesos + " accesos");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getAccesos() {
		return accesos;
	}

	public void setAccesos(int accesos) {
		this.accesos = accesos;
	}	
}
