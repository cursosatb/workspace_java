import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * implementa un programa que solicite al usuario que introduzca un número por
		 * pantalla y en función del número introducido se muestre el siguiente mensaje
		 * para cada número:
		 * 
		 * 1 --> Gestores
		 * 
		 * 2 --> Clientes
		 * 
		 * 3 --> Transferencias
		 * 
		 * 4 --> Mensajes
		 * 
		 * 5 --> Préstamos
		 * 
		 * 6 -> Salir
		 * 
		 * Para el resto de números no se mostrará ningún mensaje por pantalla.
		 */
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("1. Gestores");
		System.out.println("2. Clientes");
		System.out.println("3. Transferencias");
		System.out.println("4. Mensajes");
		System.out.println("5. Préstamos");
		System.out.println("6. Salir");
		
		System.out.print("Introduzca elección: ");
		int eleccion = keyboard.nextInt();
			
		if(eleccion == 1) {
			System.out.println("Gestores");
		}
		else if(eleccion == 2) {
			System.out.println("Clientes");
		}
		else if(eleccion == 3) {
			System.out.println("Transferencias");
		}
		
		
		
		
		
		
		
		
		
		keyboard.close();				
	}

}
