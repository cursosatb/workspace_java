package antiguo;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {

		/*
		 * Realiza un programa que calcule el factorial de un número a partir
		 * de un número introducido por el usuario
		 */
		
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print("Introduzca un número: ");
//		int numero = keyboard.nextInt();
		
//		int resultado = 400;
		
		// incrementa en 1
//		resultado++;
//		System.out.println(resultado);
		
		/*
		 * Primera iteración
		 * - i se inicializa a 1
		 * - se evalúa la condición
		 * 
		 * Segunda iteración y siguientes
		 * - i se incrementa en uno (i++)
		 * - se evalúa la condición
		 */
		
		int resultado = 1;
		for (int i=1; i<=6; i++) {
			System.out.println(i);			
			resultado = resultado * i;
		}
		System.out.println(resultado);			
		
		
		
		
//		keyboard.close();
	}

}
