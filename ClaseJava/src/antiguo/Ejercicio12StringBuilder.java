package antiguo;

public class Ejercicio12StringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Ejercicio: escribe un programa que concatene dos StringBuilder, utilizando
		 * append y tambi�n el operador concatenaci�n (para los string).
		 */
		
		StringBuilder strb1 = new StringBuilder("hola");
		StringBuilder strb2 = new StringBuilder(" adi�s");
		
		// strb1 es un StringBuilder (mutable) ha cambiado su valor
		strb1.append(strb2);
		strb2.append(strb1);
		System.out.println(strb1);
		System.out.println(strb2);
	
	}

}
