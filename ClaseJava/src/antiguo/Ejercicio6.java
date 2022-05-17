package antiguo;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		/*
		 * Escribe un programa que imprima toda la tabla de multiplicar del 5 (desde 0
		 * hasta 10).
		 */
		
		// comienzo en 0 y mientras que i sea menor o igual que 10, incremento en uno su valor
		for(int i=0; i<=10; i++) {
			int resultado = i * 5;
//			System.out.println(i + " x 5 = " + resultado);
			System.out.printf("%d x 5 = %d\n", i, resultado);
		}
	}

}
