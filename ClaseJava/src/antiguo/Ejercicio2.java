package antiguo;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {


		/*
		 * Pedir por teclado un numero al usuario si es igual o mayor que 5, mostrar un 0
		 * y si es menor que 5, mostrar un 1. Utilizar el operador ternario
		 * 
		 */
		
		// int n6 = (n5 == 6) ? 8 : 10;
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Introduzca un número: ");
		int numero = keyboard.nextInt();
		int numero2 = (numero >= 5) ? 0 : 1;
		System.out.println(numero2);

	}

}
