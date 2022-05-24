package main.unhilo;

public class MainMultiple {

	public static long fibonacci(int number) {
		return (number <= 1) ? number :  fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static void main(String[] args) {		

		long tiempoInicio = System.currentTimeMillis();
		
		for(int i=0; i<10; i++) {
			long resultado = MainMultiple.fibonacci(46);
			System.out.println(resultado);
		}
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000;	// 516 segundos
		System.out.println("Tiempo: " + tiempoTotal);
	}
}