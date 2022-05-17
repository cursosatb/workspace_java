package cursoherencia;

public class Profesor extends Persona {

	// atributos
	private int numeroDeEdadesEstudiantes;
	private double sumaDeEdadesEstudiantes;
	private double estudiantesEdadMedia;

	// constructor parametrizado
	public Profesor(int id, int edad, int telefono, int numeroDeEdadesEstudiantes, 
			double sumaDeEdadesEstudiantes, double estudiantesEdadMedia) {
		
		super(id, edad, telefono);
		this.numeroDeEdadesEstudiantes = numeroDeEdadesEstudiantes;
		this.sumaDeEdadesEstudiantes = sumaDeEdadesEstudiantes;
		this.estudiantesEdadMedia = estudiantesEdadMedia;
	}
	
	// métodos no estáticos
	public void agregarEdadEstudiante(int edad) {
		System.out.println("Método agregarEdadEstudiante de Profesor");
	}
	
	public void mostrarInfo() {
		System.out.println("Método mostrarInfo de Profesor");
	}

	public int getNumeroDeEdadesEstudiantes() {
		return numeroDeEdadesEstudiantes;
	}

	public void setNumeroDeEdadesEstudiantes(int numeroDeEdadesEstudiantes) {
		this.numeroDeEdadesEstudiantes = numeroDeEdadesEstudiantes;
	}

	public double getSumaDeEdadesEstudiantes() {
		return sumaDeEdadesEstudiantes;
	}

	public void setSumaDeEdadesEstudiantes(double sumaDeEdadesEstudiantes) {
		this.sumaDeEdadesEstudiantes = sumaDeEdadesEstudiantes;
	}

	public double getEstudiantesEdadMedia() {
		return estudiantesEdadMedia;
	}

	public void setEstudiantesEdadMedia(double estudiantesEdadMedia) {
		this.estudiantesEdadMedia = estudiantesEdadMedia;
	}

	@Override
	public void mostrarID() {
		System.out.println(this.id);		
	}
	
	
}
