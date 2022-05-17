package cursointerfaces;

public interface VehiculoInterfaz {

	public static final float g = 9.8f;
	
	public abstract void parar();
	public abstract void acelerar();
	public abstract void desacelerar();
	public abstract void girarIzquierda();
	public abstract void girarDerecha();
}
