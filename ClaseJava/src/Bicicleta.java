
public class Bicicleta extends Vehiculo {

	// atributo de la bicicleta
	private int cambios;

	// constructor
	public Bicicleta(float velocidad, int asientos, int orientacionRuedas, int cambios) {
		super(velocidad, asientos, orientacionRuedas);
		this.cambios = cambios;
	}
	
	public void parar() {
		System.out.println("Método parar de Bicicleta");
	}

	public int getCambios() {
		return cambios;
	}

	public void setCambios(int cambios) {
		this.cambios = cambios;
	}
}
