package antiguo;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		/*
		 * Escribe un programa que obtenga los n?meros enteros comprendidos entre dos
		 * n?meros introducidos por teclado y validados como distintos
		 */
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Introduzca el primer n?mero: ");
		int numero1 = keyboard.nextInt();
		System.out.print("Introduzca el segundo n?mero: ");
		int numero2 = keyboard.nextInt();
		
		// si numero1 es igual a numero2
		if(numero1 == numero2) {
			System.out.println("Los dos n?meros son iguales");
			keyboard.close();
			return;
		}
		
		System.out.println("Continua el programa...");
		
		int numeroMayor, numeroMenor;
		if(numero1 > numero2) {
			numeroMayor = numero1;
			numeroMenor = numero2;
		}
		else {
			numeroMayor = numero2;
			numeroMenor = numero1;
		}		
		
		for (int i = numeroMenor; i <= numeroMayor; i++) {
			System.out.println(i);
		}		
		
		keyboard.close();		
	}
}
