package com.teatro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Obra obra = new Obra("LA BOMBILLA DE DON BLAS", "Sol, 45", 
				300, 2, "La cena de los idiotas", "Comedia", 95, 30.0);
		
		
		double numero = 34445.3455;
//		System.out.printf("%.2f", numero); 
//		System.out.printf("%1.2f", 32.14159);
		
//		int edad = 18;
//		while(edad < 25) {
//			edad++;
//		}
		
		String palabra = "Joaquín";
		System.out.println(palabra.charAt(palabra.length() - 1));
		
		int numero2 = Integer.valueOf("43");
		
//		ArrayList<Double> numeros = new ArrayList<Object> ();
//		numeros.add(4);
//		numeros.add(2);
//		numeros.add(3);
//		numeros.add(1);
		
//		System.out.println(numeros.size());
//		System.out.println(numeros.get(0));
		
		
		
		
//		for (int i = 0; i < 10; i--) {
//			
//		}
		
		
	
//		System.out.println(obra.getLocalidades().size());
		
		// mostramos el menú
//		Main.menu(obra);
	}
	
	public static int sumar(int numero1, int numero2) {
		return numero1 + numero2;
	}
	
	public int restar(int numero1, int numero2) {
		return numero1 - numero2;
	}
	
	public static void menu(Obra obra) {
		
		Scanner keyboard = new Scanner(System.in);
		
		// invocación de método estático
		/*Main.sumar(2, 3);
		
		// invocación de método no estático
		Main main = new Main();
		main.restar(2, 1);
		main.sumar(1, 2);
*/
//		Main.sumar(1, 2);
//		sumar(1,2);
		
		
		
		int eleccion = 6;
		
		do {

			// MENÚ PRINCIPAL
			System.out.println("TEATRO " + obra.getNombre());
			System.out.println("--------------------------------");
			System.out.println("1. Ver la programación actual");
			System.out.println("2. Mostrar todas las localidades");
			System.out.println("3. Mostrar localidades ocupadas");
			System.out.println("4. Vender localidad");
			System.out.println("5. Cancelar localidad");
			System.out.println("6. Consultar localidad");
			System.out.println("7. Calcular recaudación");
			System.out.println("8. Terminar programa\n");
			System.out.println("¿Qué opción deseas?");
			eleccion = keyboard.nextInt();

			if (eleccion == 1) {
				obra.verProgramacion();
			} else if (eleccion == 2) {
				obra.mostrarTodasLocalidades();
			} else if (eleccion == 3) {
				obra.mostrarLocalidadesOcupadas();
			} else if (eleccion == 4) {
				obra.venderLocalidad(keyboard);
			} else if (eleccion == 5) {
				obra.cancelarLocalidad(keyboard);
			} else if (eleccion == 6) {
				obra.consultarLocalidad(keyboard);
			} else if(eleccion == 7) {
				obra.calcularRecaudacion();
			}
			else if (eleccion == 8) {
				System.out.println("Salir");
			}

		} while (eleccion != 8);
		
		keyboard.close();
	}

}
