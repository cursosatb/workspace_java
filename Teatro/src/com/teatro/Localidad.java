
package com.teatro;

public class Localidad {

	private boolean ocupado;
	
	// fila y butaca mantienen su valor inalterado una vez se 
	// establece en la inicialización (constructor)
	private final int fila;
	private final int butaca;
	
	// atributos de la persona que reserva la localidad
	private String nombre;
	private int telefono;
	private String tipo;	// tipo toma los valores INFANTIL, MENOR, MAYOR o JUBILADO
	private double precioTotal;
	
	public Localidad(boolean ocupado, int fila, int butaca, String nombre, int telefono, String tipo,
			double precioTotal) {
		this.ocupado = ocupado;
		this.fila = fila;
		this.butaca = butaca;
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipo = tipo;
		this.precioTotal = precioTotal;
	}

	public void mostrarLocalidad() {
		
		// (this.ocupado == false) Si no está ocupada
		if(!this.ocupado) {
			System.out.println("Localidad no ocupada");
		}
		// si la localidad está ocupada
		else {
			System.out.println("Localidad ocupada por "  + this.nombre
					+ ", tlf: " + this.telefono
					+ ", Tipo: " + this.tipo 
					+ ", Precio: " + this.precioTotal);
		}
	}
	
	// reiniciar todos los atributos de la persona que reservó la localidad
	public void cancelarLocalidad() {
		this.ocupado = false;
		this.nombre = null;
		this.telefono = 0;
		this.tipo = null;
		this.precioTotal = 0.0;
	}
	
	public void reservarLocalidad(String nombre, int telefono, int edad, double precio) {
		this.ocupado = true;
		this.nombre = nombre;
		this.telefono = telefono;
		
		// si la edad es mayor o igual que 0 y menor o igual que 12
		if((edad >= 0) && (edad <= 12)) {
			this.tipo = "INFANTIL";
			this.precioTotal = precio - precio * 0.5;
		}
		// si la edad es mayor o igual que 13 y menor o igual que 17
		else if((edad >= 13) && (edad <= 17)) {
			this.tipo = "MENOR";
			this.precioTotal = precio - precio * 0.2;
		}
		else if((edad >= 18) && (edad <= 64)) {
			this.tipo = "MAYOR";
			this.precioTotal = precio;
		}
		else if(edad >= 65) {
			this.tipo = "JUBILADO";
			this.precioTotal = precio - precio * 0.66;
		}
		
		/*
		 * Cálculo del precio
		 */
		// if(this.tipo === "INFANTIL") (JavaScript)
//		if (this.tipo.equals("INFANTIL")) {
//			this.precioTotal = precio / 2;
//		}
//		else if(this.tipo.equals("MENOR")) {
//			this.precioTotal = precio - precio/5;
//		}
//		else if(this.tipo.equals("MAYOR")) {
//			
//		}
			
	}	

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getFila() {
		return fila;
	}

	public int getButaca() {
		return butaca;
	}
}
