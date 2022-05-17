import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);

		System.out.println("1. Gestores");
		System.out.println("2. Clientes");
		System.out.println("3. Transferencias");
		System.out.println("4. Mensajes");
		System.out.println("5. Préstamos");
		System.out.println("6. Salir");

		/*
		 * Ejercicio proyecto (Main2): Solicita continuamente un número al usuario
		 * hasta que éste sea 6
		 */
		
		int eleccion = 6;
		do {
			System.out.print("Introduzca elección: ");
			eleccion = keyboard.nextInt();
		} while(eleccion != 6);
		
		if (eleccion == 1) {
			System.out.println("Gestores");
		} 
		else if (eleccion == 2) {
			System.out.println("Clientes");
		} 
		else if (eleccion == 3) {
			System.out.println("Transferencias");
		}
		else if (eleccion == 6) {
			System.out.println("Salir");
		}

		keyboard.close();
	}

}
