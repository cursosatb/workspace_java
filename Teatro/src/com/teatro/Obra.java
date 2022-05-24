package com.teatro;

import java.time.LocalDate;
import java.util.Scanner;

public class Obra extends Teatro {

	private String titulo;
	private String genero;
	private int duracion;
	private double precio;

	public Obra(String nombre, String calle, int superficie, int accesos, 
			String titulo, String genero, int duracion, double precio) {
		
		// invocación al constructor de la superclase (Teatro)
		super(nombre, calle, superficie, accesos);
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.precio = precio;
	}

	public void mostrarObra() {
		System.out.println(
				"Hoy representamos " + this.titulo + ", género: " + this.genero + ", Duración: " + this.duracion);
	}
	
	public void mostrarPrecio() {
		System.out.println("Precio: " + this.precio);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	// opción 1 del menú
	public void verProgramacion() {
		this.mostrarObra();
		this.mostrarTeatro();
		this.mostrarPrecio();
	}
	
	public boolean estaOcupadoLocalidad(int fila, int butaca) {
		for(Localidad localidad : this.localidades) {
			if ((localidad.getFila() == fila) && (localidad.getButaca() == butaca)) {
				
				// en este punto del método, la localidad EXISTE
				return localidad.isOcupado();
			}
		}	
		
		// en este punto del método, la localidad NO existe
		return true;
	}

	// opción 2 del menú
	public void mostrarTodasLocalidades() {

		int contador = 0;
		for(Localidad localidad : this.localidades) {
			
//			String ocupada = (CONDICION) ? VALOR_SI_CUMPLE : VALOR_SI_NO_CUMPLE;
			String ocupada = (localidad.isOcupado()) ? "Ocupada" : "Libre";
			System.out.print(localidad.getFila() + "." + localidad.getButaca() + " "  + ocupada + "  ");
			
			contador++;
			if(contador == 10) {
				System.out.println();
				contador = 0;
			}
		}		
	}

	// opción 3 del menú
	public void mostrarLocalidadesOcupadas() {
		
		boolean estanTodosLibres = true;
		
		for(Localidad localidad : this.localidades) {
			if(localidad.isOcupado()) {
				System.out.println(localidad.getFila() + "." + localidad.getButaca()
									+ " " + localidad.getNombre()
									+ ", tlf: " + localidad.getTelefono()
									+ ", Tipo: " + localidad.getTipo());
				estanTodosLibres = false;
			}
		}
		
		if(estanTodosLibres) {
			System.out.println("Están todos libres");
		}
		
	}

	// opción 4 del menú
	public void venderLocalidad(Scanner keyboard) {
		
		System.out.println("¿En qué fila quieres sentarte (0-4)?");
		int fila = keyboard.nextInt();
		
		System.out.println("¿Y en qué butaca (0-9)?");
		int butaca = keyboard.nextInt();
		
		System.out.println("¿Cómo se llama?");
		String nombre = keyboard.next();
		
		System.out.println("¿Su teléfono?");
		int telefono = keyboard.nextInt();
		
		System.out.println("¿Cuántos años tiene?");
		int edad = keyboard.nextInt();
		
		
		if(String.valueOf(telefono).length() != 9) {
			System.err.println("Teléfono no válido");			
		}
		
//		if(telefono.toString().length() != 9) {
//			System.err.println("Teléfono no válido");
//			return;
//		}
		
		if(this.estaOcupadoLocalidad(fila, butaca)) {
			System.err.println("Está ocupado o no existe la localidad");
			return;
		}
		
		if(nombre.length() == 0) {
			System.err.println("El nombre no puede estar vacío");
			return;
		}
		
		if((fila < 0) || (fila > 4)) {
			System.err.println("No existe esa fila");
			return;
		}
		
		if((butaca < 0) || (butaca > 9)) {
			System.err.println("No existe esa butaca");
			return;
		}
		
		// en este punto del programa, puedo reservar la localidad
		for(Localidad localidad : this.localidades) {
			if ((localidad.getFila() == fila) && (localidad.getButaca() == butaca)) {
				localidad.reservarLocalidad(nombre, telefono, edad, this.precio);
				System.out.println("Se ha vendido la localidad "
						+ localidad.getFila() + "." + localidad.getButaca()
						+ " a " + localidad.getNombre() + " por " 
						+ localidad.getPrecioTotal() + " euros");
			}
		}
	}

	// opción 5 del menú
	public void cancelarLocalidad(Scanner keyboard) {

		System.out.println("¿Fila (0-4)?");
		int fila = keyboard.nextInt();
		
		System.out.println("¿Butaca (0-9)?");
		int butaca = keyboard.nextInt();
		
		for(Localidad localidad : this.localidades) {
			if ((localidad.getFila() == fila) && (localidad.getButaca() == butaca)) {

				// en este punto del programa sabemos que la localidad existe
					
				// si está ocupada la localidad, cancelamos la reserva
				if(localidad.isOcupado()) {
					
					System.out.println(localidad.getNombre() + " ha cancelado su reserva");

					// establece todos los valores del cliente a los valores por defecto
					localidad.cancelarLocalidad();
					
				}
				
				// y si no, mostramos un mensaje
				else {
					System.out.println("La plaza ya está libre");
				}
				
			}
		}
		
		
	}

	public void consultarLocalidad(Scanner keyboard) {

		System.out.println("¿Fila (0-4)?");
		int fila = keyboard.nextInt();
		
		System.out.println("¿Butaca (0-9)?");
		int butaca = keyboard.nextInt();
		
		for(Localidad localidad : this.localidades) {
			if ((localidad.getFila() == fila) && (localidad.getButaca() == butaca)) {
				localidad.mostrarLocalidad();
			}
		}
			
	}

	public void calcularRecaudacion() {
		// TODO Auto-generated method stub
		
		double recaudacionTotal = 0.0;
		
		for(Localidad localidad : this.localidades) {
			recaudacionTotal += localidad.getPrecioTotal(); 
		}		
		
		System.out.println("Recaudación: " + recaudacionTotal);
			
	}
	
}
