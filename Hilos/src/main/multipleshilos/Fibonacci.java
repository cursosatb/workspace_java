package main.multipleshilos;

public class Fibonacci implements Runnable {

	private int id;
	
	public Fibonacci(int id) {
		this.id = id;
	}
	
	public static long fibonacci(int number) {
		  return (number <= 1) ? number :  fibonacci(number - 1) + fibonacci(number - 2);
	}
	
	@Override
	public void run() {
		
		long tiempoInicio = System.currentTimeMillis();
		long resultado = Fibonacci.fibonacci(48);
		System.out.println(resultado);
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000;
		System.out.println("id: " + id + " - tiempo: " + tiempoTotal + "s");
		
	}

}
