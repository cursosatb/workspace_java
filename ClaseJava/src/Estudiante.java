
public class Estudiante {
	
	// atributos
	private int id;
	private int edad;
	private int telefono;
	private int numeroDeNotas;
	private double sumaDeNotas;
	private double notaMedia;

	// constructor por defecto
	public Estudiante() {
	}

	// constructor parametrizado (todos los parámetros)
	public Estudiante(int id, int edad, int telefono, int numeroDeNotas, double sumaDeNotas, double notaMedia) {
		this.id = id;
		this.edad = edad;
		this.telefono = telefono;
		this.numeroDeNotas = numeroDeNotas;
		this.sumaDeNotas = sumaDeNotas;
		this.notaMedia = notaMedia;
	}

	public Estudiante(int id, int edad) {
		this.id = id;
		this.edad = edad;
	}

	public Estudiante(int id, int edad, int telefono) {
		this.id = id;
		this.edad = edad;
		this.telefono = telefono;
	}

	// métodos estáticos
	public static Estudiante crearEstudiante() {
		Estudiante estudiante = new Estudiante();
		return estudiante;
	}

	// métodos no estáticos
	public void mostrarInfo() {
	}

	/*
	 * Implementa dos métodos sobrecargados para agregarNuevaNota: 
	 * 	Primer método: recibe como parámetro una nota (valor de tipo flotante). 
	 *  Segundo método: recibe como parámetro una nota y una variable booleana para reiniciar a cero los atributos numeroDeNotas,
	 * sumaDeNotas y notaMedia. 
	 * El funcionamiento general del método agregarNuevaNota es: 
	 * - Aumentar un valor el atributo numeroDeNotas
	 * - Sumar la nueva nota al atributo sumaDeNotas
	 * - Obtener el nuevo valor de notaMedia dividiendo sumaDeNotas por numeroDeNotas.
	 */
	public void agregarNuevaNota(double nuevaNota) {
		this.numeroDeNotas++;
		this.sumaDeNotas += nuevaNota;
		this.notaMedia = this.sumaDeNotas / this.numeroDeNotas;
	}
	
	public void agregarNuevaNota(double nuevaNota, boolean reiniciar) {
		if(reiniciar) {
			this.numeroDeNotas = 0;
			this.sumaDeNotas = 0;
			this.notaMedia = 0;
		}
		
		this.agregarNuevaNota(nuevaNota);
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", edad=" + edad + ", telefono=" + telefono + ", numeroDeNotas=" + numeroDeNotas
				+ ", sumaDeNotas=" + sumaDeNotas + ", notaMedia=" + notaMedia + "]";
	}

	// métodos getters y setters
	public int getId() {
		return this.id;
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

	public int getNumeroDeNotas() {
		return numeroDeNotas;
	}

	public double getSumaDeNotas() {
		return sumaDeNotas;
	}

	public double getNotaMedia() {
		return notaMedia;
	}
}
