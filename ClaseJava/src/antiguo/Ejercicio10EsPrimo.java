package antiguo;
import java.util.Scanner;

public class Ejercicio10EsPrimo {
	
	/*
	 * Crear un método que se llama esPrimo. Reciba un número entero (int) y devuelva un 
	 * booleano. Si el número es primo entonces tiene que devolver true y si no, false
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Introduzca el primer número: ");
		int numero1 = keyboard.nextInt();
		
		if(Ejercicio10EsPrimo.esPrimo(numero1)) {
			System.out.println("Es primo");
		}
		else {
			System.out.println("No es primo");
		}	
	}
	
	public static boolean esPrimo(int numero) {
		for(int i=numero-1; i >= 2; i--) {
			if(numero % i == 0) {
				// System.out.println("No es primo");
				return false;
			}
		}
		
		// es primo
		return true;
	}
}
