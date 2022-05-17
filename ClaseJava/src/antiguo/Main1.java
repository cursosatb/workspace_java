package antiguo;

public class Main1 {

	public static void main(String[] args) {

		System.out.println("Hola mundo");

		// suma
		System.out.println(5 + 2);

		/*
		 * resta
		 */
		System.out.println(5 - 2);
		System.out.println(5 * 2);
		System.out.println(5 / 2);
		System.out.println(5 % 2);
		System.out.println(Math.pow(5, 3));
		System.out.println(5.0 / 2);
		System.out.println("2*3");
		System.out.println(2 * 3);

		/*
		 * Secuencias de escape
		 */
		System.out.println("\t\"Hola\nmundo\"");
		System.out.println("  \"  "); // para que aparezca una comilla (")
		System.out.println("  \\  "); // para que aparezca una barra invertida (/)

		/*
		 * printf
		 */
		System.out.printf("El producto de 5*2 = %d", 5 * 2).println();
		System.out.printf("5 + 6 + 7 = %d", 5 + 6 + 7).println();

		/*
		 * Variables numéricas
		 */
		// const edad: number = 18;

		// variable de tipo entero
		int edad = 18;
		System.out.println(edad);

		// variable de tipo flotante (con decimales)
		double precioBarraPan = 4.3;
		System.out.println(precioBarraPan);

		/*
		 * Ejercicio: escribe un programa que declare tres variables de nombre a, b y c,
		 * con valores de tipo entero. A continuación:
		 * 
		 * Escribe una sentencia que muestre por pantalla la suma de las tres variables
		 * utilizando System.out.println. Cambia el valor de la variable c. Escribe de
		 * nuevo una sentencia que muestre por pantalla la suma de las tres variables
		 * utilizando System.out.printf.
		 */
		
		System.out.println("Ejercicio");
		int a=3, b=4, c=5;
		System.out.println(a + b + c);
		System.out.printf("%d + %d + %d = %d", a, b, c, a + b + c).println();
		
		int numero1 = 1;
		int numero2 = 2;
		int numero3 = numero1 + numero2;
		
		short numero4 = 32767;
		short numero5 = (short) (numero4 + 1);
		System.out.println(numero5);
		
		double numero6 = 5.6;
		float numero7 = (float) numero6;
		
		// char solamente para guardar una letra y se utiliza comillas simples
		char letra = 'j';
		
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println(bool1);
		
		// a una variable de tipo primitivo no se le puede asignar el valor de null
		// bool1 = null;
		
		/*
		 * operador de asignación compuesto  
		 */
		int n = 5;
		
		// n = n + 6
		n += 6;
		
		// n = n + 1
		// n += 1
		n++;
		
		System.out.println(n);
		
		/*
		 * conversión de tipos
		 */
		
		// conversión automática
		byte b1 = 9;	// byte son 8 bits (1 byte)
		long l1 = b1;   // long son 64 bits (8 bytes)
		
		// conversión con casting o explícita
		long l2 = 800;
		byte b2 = (byte) l2;
		System.out.println(b2);
		
		/*
		 * Visibilidad de las variables
		 */
		
		int a1;
		a1 = 6;
		System.out.println(a1);
		
		/*
		 * Operador de negación
		 */
		
		boolean bool3 = true;
		boolean bool4 = !bool3;
		System.out.println(bool4);
		
		/*
		 * Operador ternario
		 */
		int n5 = 10;
//		int n6;
//		if (n5 == 6) {
//			n6 = 8;
//		}
//		else {
//			n6 = 10;
//		}
//		int n6 = (CONDICION) ? VALOR_SI_CUMPLE : VALOR_SI_NO_CUMPLE;
		int n6 = (n5 == 6) ? 8 : 10;
		System.out.println(n6);
		

	}

}
