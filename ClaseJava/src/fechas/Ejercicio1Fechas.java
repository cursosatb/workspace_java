package fechas;

import java.time.LocalDateTime;

public class Ejercicio1Fechas {

	public static void main(String[] args) {

		/*
		 * Ejercicio: escribe un programa que obtenga la fecha y hora actual con
		 * LocalDateTime. A continuación, realizar las siguientes operaciones con la
		 * fecha:
		 * 
		 * Sumar 1 día. 
		 * Sumar 1000 milisegundos. 
		 * Restar 1 año. 
		 * Restar 1 mes.
		 */
		
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusDays(1);
		ldt = ldt.plusNanos(1000000000);
		ldt = ldt.minusYears(1);
		ldt = ldt.minusMonths(1);
		
		System.out.println(ldt);
		
		
		
	}

}
