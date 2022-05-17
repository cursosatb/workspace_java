package antiguo;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

//		System.out.println(4.3 >= 4);
//		System.out.println(4 < 4);
//		System.out.println(2 != 5);

		/*
		 * Ejercicio: escribe un programa con una variable de tipo entero (a) y un
		 * condicional que evalúe si el entero es par o impar utilizando el operador %.
		 */
//		int a = 8;
//		if (a % 2 == 0) {
//			System.out.println("Es par");
//		} else {
//			System.out.println("Es impar");
//		}

		/*
		 * Introducción de datos por teclado
		 */
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print("Introduzca número: ");
//		
//		// aquí se queda detenido el programa hasta que pulses intro
//		int numero = keyboard.nextInt();
//		System.out.println(numero);
//				
//		keyboard.close();

		/*
		 * Realiza un programa que calcule la media de tres notas. Las tres se
		 * introducen mediante Scanner y nextDouble
		 */

		Scanner keyboard = new Scanner(System.in);

		// introducir la primera nota
		System.out.print("Introduzca primera nota: ");
		double nota1 = keyboard.nextDouble();

		// introducir la segunda nota
		System.out.print("Introduzca segunda nota: ");
		double nota2 = keyboard.nextDouble();

		// introducir la tercera nota
		System.out.print("Introduzca la tercera nota: ");
		double nota3 = keyboard.nextDouble();

		double notaMedia = (nota1 + nota2 + nota3) / 3;
		System.out.println("La nota media es " + notaMedia);
		System.out.printf("La nota media es %f", notaMedia).println();

		/*
		 * Amplía el programa anterior para que diga la nota media (insuficiente (<5),
		 * suficiente (>=5 y <6), bien(>=6 y <8), notable(>=8 y <9) o sobresaliente(>=9).
		 * Si la nota no está entre 0 y 10, mostrar en pantalla un aviso con println
		 */
		if ((notaMedia >= 0) && (notaMedia < 5)) {
			System.out.println("insuficiente");
		}
		else if ((notaMedia >= 5) && (notaMedia < 6)) {
			System.out.println("suficiente");
		}
		else if((notaMedia >= 6) && (notaMedia < 8)) {
			System.out.println("bien");
		}
		else if(notaMedia >= 8 && notaMedia < 9) {
			System.out.println("notable");
		}
		else if((notaMedia >= 9) && (notaMedia < 10)) {
			System.out.println("sobresaliente");
		}
		else {
			System.out.println("La nota media no está entre 0 y 10");
		}
		

		keyboard.close();

	}
}
