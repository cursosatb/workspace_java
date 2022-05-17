package cursoherencia;

public class Estudiante extends Persona {

	// atributos
	private int numeroDeNotas;
	private double sumaDeNotas;
	private double notaMedia;
	
	// constructor parametrizado
	public Estudiante(int id, int edad, int telefono, int numeroDeNotas, 
			double sumaDeNotas, double notaMedia) {
		
		super(id, edad, telefono);
		this.numeroDeNotas = numeroDeNotas;
		this.sumaDeNotas = sumaDeNotas;
		this.notaMedia = notaMedia;	
	}	
	
	// Métodos publicos no estáticos y estáticos
	public static void crearEstudiante() {
//		Estudiante estudiante = new Estudiante();
//		return estudiante;
	}

	// métodos no estáticos
	public void mostrarInfo() {
		System.out.println("Método mostrarInfo de Estudiante");
	}
	
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

	// métodos getters y setters
	public int getNumeroDeNotas() {
		return numeroDeNotas;
	}

	public void setNumeroDeNotas(int numeroDeNotas) {
		this.numeroDeNotas = numeroDeNotas;
	}

	public double getSumaDeNotas() {
		return sumaDeNotas;
	}

	public void setSumaDeNotas(double sumaDeNotas) {
		this.sumaDeNotas = sumaDeNotas;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public void mostrarID() {
		System.out.println(this.id);
	}
	
}
