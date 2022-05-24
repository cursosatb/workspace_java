package main.unhilo;

public class MainUno {

	public static long fibonacci(int number) {
		  return (number <= 1) ? number :  fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static void main(String[] args) {		

		long tiempoInicio = System.currentTimeMillis();
		
		long resultado = MainUno.fibonacci(50);
		System.out.println(resultado);
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000; // 48 segundos
		System.out.println("Tiempo: " + tiempoTotal);
	}
}