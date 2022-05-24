package fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// crear un objeto de tipo fecha (la forma antigua de Java)
		Date fecha = new Date();
		
		// crear un objeto de tipo fecha (forma moderna de Java)
		LocalDate ld = LocalDate.now();
//		System.out.println(ld);
		
		// muestra el año
//		System.out.println(ld.getYear());
		
		// muestra si el año es bisiesto (true o false)
//		System.out.println(ld.isLeapYear());
		
		// mostrar el mes (en número)
//		System.out.println(ld.getMonthValue());
		
		// mostrar el día
//		System.out.println(ld.getDayOfMonth());
		
		// crear un objeto LocalDate en un momento concreto del tiempo
		LocalDate dt2 = LocalDate.of(2011, 11, 9);
		
		// crear un objeto de tipo hora (forma moderna de Java)
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		System.out.println(lt.getHour());
		System.out.println(lt.getMinute());
		System.out.println(lt.getSecond());
		
		// crear un objeto de tipo fecha y hora (forma moderna de Java)
		LocalDateTime dt = LocalDateTime.now(); 
		System.out.println(dt);

		// sumar 30 años al momento actual
		dt = dt.plusYears(30);
		System.out.println(dt);
		
		
	}

}
