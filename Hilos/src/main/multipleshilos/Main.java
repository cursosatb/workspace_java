package main.multipleshilos;

public class Main {

	public static void main(String[] args) {		
		
		for(int i=0; i<100; i++) {
			Fibonacci fibonacci = new Fibonacci(i);
			Thread thread = new Thread(fibonacci);
			thread.start();
		}
		
		System.out.println("Programa finalizado");
	}
	// 82 segundos
}