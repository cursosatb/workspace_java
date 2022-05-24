
public class Monedero {

	private double cantidad;
	
	public Monedero(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void verDinero() {
		System.out.println("Tengo " + this.cantidad + " € en el monedero");
	}
	
	public void meterDinero(double dinero) {
		// this.cantidad = this.cantidad + dinero
		this.cantidad += dinero;
	}
	
	public void sacarDinero(double dinero) {
		this.cantidad -= dinero;
	}

	public double getCantidad() {
		return cantidad;
	}

//	public void setCantidad(double cantidad) {
//		this.cantidad = cantidad;
//	}
	
	
}
