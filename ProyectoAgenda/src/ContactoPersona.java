
public class ContactoPersona extends Contacto {
	
	private String cumpleanos;

	public ContactoPersona(String nombre, int telefono, String cumpleanos) {
		
		// invoca al constructor de la superclase (Contacto)
		super(nombre, telefono);
		this.cumpleanos = cumpleanos;
	}

	@Override
	public void mostrarInfo() {
		System.out.println(this.nombre 
				+ " tiene el teléfono " + this.telefono
				+ " y cumpleaños " + this.cumpleanos);
		
	}	

	public String getCumpleanos() {
		return cumpleanos;
	}

	public void setCumpleanos(String cumpleanos) {
		this.cumpleanos = cumpleanos;
	}

	@Override
	public String toString() {
		return "ContactoPersona [cumpleanos=" + cumpleanos + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
