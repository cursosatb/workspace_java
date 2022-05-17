package com.banco;
import java.io.IOException;
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner keyboard = new Scanner(System.in);

		int eleccion = 6;
		
		do {

			// MENÚ PRINCIPAL
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

			if (eleccion == 1) {
				Main6.menuGestores(keyboard);
			} else if (eleccion == 2) {
				Main6.menuClientes();
			} else if (eleccion == 3) {
				Main6.menuTransferencias();
			} else if (eleccion == 6) {
				System.out.println("Salir");
			}

		} while (eleccion != 6);
		
		keyboard.close();
	}
	
	public static void menuGestores(Scanner keyboard) {
		

		int eleccion = 6;
		
		do {

			// MENÚ GESTORES
			System.out.println("---");
			System.out.println("1. Agregar gestor");
			System.out.println("2. Modificar gestor");
			System.out.println("3. Eliminar gestor");
			System.out.println("4. Ver gestor");
			System.out.println("5. Ver gestores");
			System.out.println("6. Atrás");
			System.out.println("---");
			System.out.print("Introduzca elección: ");
			eleccion = keyboard.nextInt();

			if (eleccion == 1) {
				System.out.println("Agregar gestor");
			} else if (eleccion == 2) {
				System.out.println("Modificar gestor");
			} else if (eleccion == 3) {
				System.out.println("Eliminar gestor");
			} else if (eleccion == 6) {
				System.out.println("Salir");
			}

		} while (eleccion != 6);
		
	}
	
	public static void menuClientes() {
		System.out.println("Clientes");
	}
	
	public static void menuTransferencias() {
		System.out.println("Transferencias");
	}

}
