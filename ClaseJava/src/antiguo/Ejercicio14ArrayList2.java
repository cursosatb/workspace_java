package antiguo;

import java.util.ArrayList;

public class Ejercicio14ArrayList2 {

	public static void main(String[] args) {

		/*
		 * Realiza un programa que introduzca 50 valores aleatorios (entre 0 y 100) en un
		 * ArrayList y que luego calcule la suma, la media, el m�ximo y el m�nimo de
		 * esos números.
		 */
		
//		double numeroAleatorio = Math.random() * 100;

		ArrayList<Double> numeros = new ArrayList<Double>();
		
		for(int i=0; i<50; i++) {
			numeros.add(Math.random() * 100);
		}
		
//		System.out.println(numeros);
		
		// suma de todos los números
		double suma = 0.0;
		for(Double numero: numeros) {
//			System.out.println(numero);
			suma += numero;
		}
		
		// media de todos los números
		double media = suma / numeros.size();
		
		// número mínimo de todos los números
		double minimo = 100.0;
		for(Double numero: numeros) {
			if(numero < minimo) {
				minimo = numero;
			}
		}
		
		// número máximo de todos los números
		double maximo = 0.0;
		for(Double numero: numeros) {
			if(numero > maximo) {
				maximo = numero;
			}
		}				
		
		System.out.println("Suma:" + suma);
		System.out.println("Media:" + media);
		System.out.println("Mínimo:" + minimo);
		System.out.println("Máximo:" + maximo);
	}

}
