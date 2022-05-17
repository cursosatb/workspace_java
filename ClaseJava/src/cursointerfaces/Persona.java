package cursointerfaces;

public abstract class Persona implements PersonaInterfaz {

	// atributos
	protected int id;
	protected int edad;
	protected int telefono;
	
	// constructor
	public Persona(int id, int edad, int telefono) {
		// invoca al constructor de la clase Object
		super();
//		System.out.println("Constructor de la clase Persona");
		this.id = id;
		this.edad = edad;
		this.telefono = telefono;
	}
	
	public abstract void mostrarID();
	
	// Métodos publicos no estáticos
	public void mostrarInfo() {
		System.out.println("Método mostrarInfo de Persona");
	}

	// métodos getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
