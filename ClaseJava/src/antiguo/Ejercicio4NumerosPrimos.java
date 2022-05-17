package antiguo;
import java.util.Scanner;

public class Ejercicio4NumerosPrimos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Ejercicio: escribe un programa que dado un número, calcule si es primo o no.
		 * Un número primo es un número natural mayor que 1 que tiene únicamente dos
		 * divisores distintos: él mismo y el 1.
		 */
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int numero = keyboard.nextInt();
		
//		System.out.println(5 % 3);
		
		for(int i=numero-1; i >= 2; i--) {
			System.out.println(numero + "%" + i + " = " + numero%i);
			if(numero % i == 0) {
				System.out.println("No es primo");
				break;
			}
		}
		
		
	}
}
