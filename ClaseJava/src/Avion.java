
// Avion hereda de Vehiculo
public class Avion extends Vehiculo {

	// atributos
	private boolean trenAterrizaje;
	
	// métodos
	public void volar() {}
	public void aterrizar() {}

	// constructor de la clase Avion
	public Avion(float velocidad, int asientos, int orientacionRuedas, boolean trenAterrizaje) {
		
		// invocación al constructor de la superclase (Vehiculo)
		super(velocidad, asientos, orientacionRuedas);
		
		System.out.println("Constructor de la clase Avion");		
		this.trenAterrizaje = trenAterrizaje;
	}
	
	public void acelerar() {
		System.out.println("Método acelerar de Avion");		
	}
	
	// método get para trenAterrizaje
	public boolean isTrenAterrizaje() {
		return trenAterrizaje;
	}
	// método set para trenAterrizaje
	public void setTrenAterrizaje(boolean trenAterrizaje) {
		this.trenAterrizaje = trenAterrizaje;
	}
	
	// se está sobrescribiendo el método abstracto parar de la clase Vehiculo
	@Override
	public void parar() {
		System.out.println("Método parar de Avion");		
	}
	
	
}
