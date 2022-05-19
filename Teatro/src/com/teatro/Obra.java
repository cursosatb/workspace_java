package com.teatro;

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

	public void verProgramacion() {
		this.mostrarObra();
		this.mostrarTeatro();
		this.mostrarPrecio();
	}

	public void mostrarTodasLocalidades() {

		for(Localidad localidad : this.localidades) {
			
			System.out.println(localidad.getFila() + "." + localidad.getButaca());
		}
		
		
	}
	
}
