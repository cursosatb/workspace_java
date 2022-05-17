import java.io.IOException;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Ejercicio proyecto (Main4): reutiliza el programa desarrollado para mostrar
		 * los mensajes (Gestores, Clientes, Transferencias, Mensajes, Préstamos) en
		 * métodos (un método por cada mensaje).
		 */

		Scanner keyboard = new Scanner(System.in);

		int eleccion = 6;
		
		do {

			System.out.println("---");
			System.out.println("1. Gestores");
			System.out.println("2. Clientes");
			System.out.println("3. Transferencias");
			System.out.println("4. Mensajes");
			System.out.println("5. Préstamos");
			System.out.println("6. Salir");
			System.out.println("---");
			System.out.print("Introduzca elección: ");
			eleccion = keyboard.nextInt();
		} while (eleccion != 6);

		if (eleccion == 1) {
			Main4.menuGestores();
		} else if (eleccion == 2) {
			Main4.menuClientes();
		} else if (eleccion == 3) {
			Main4.menuTransferencias();
		} else if (eleccion == 6) {
			System.out.println("Salir");
		}

		keyboard.close();
	}
	
	public static void menuGestores() {
		System.out.println("Gestores");
	}
	
	public static void menuClientes() {
		System.out.println("Clientes");
	}
	
	public static void menuTransferencias() {
		System.out.println("Transferencias");
	}

}
