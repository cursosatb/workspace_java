
public abstract class Vehiculo {

	// atributos que van a heredar Coche, Avion y Bicicleta
	protected float velocidad;
	protected int asientos;
	protected int orientacionRuedas;
	
	// métodos que van a heredar Coche, Avion y Bicicleta
	public abstract void parar();
	
	public void acelerar() {
		System.out.println("Método acelerar de Vehiculo");
	}
	
	public void desacelerar() {}
	public void girarIzquierda() {}
	public void girarDerecha() {}
	
	// constructor de la clase Vehiculo
	public Vehiculo(float velocidad, int asientos, int orientacionRuedas) {
		System.out.println("Constructor de Vehiculo");
		this.velocidad = velocidad;
		this.asientos = asientos;
		this.orientacionRuedas = orientacionRuedas;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public int getOrientacionRuedas() {
		return orientacionRuedas;
	}
	public void setOrientacionRuedas(int orientacionRuedas) {
		this.orientacionRuedas = orientacionRuedas;
	}
	
	
}
