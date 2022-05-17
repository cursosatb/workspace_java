package antiguo;

public class Ejercicio10String {

	public static void main(String[] args) {

		/*
		 * Ejercicio: escribe un programa que devuelva si un String es palíndromo (se
		 * escribe igual hacia delante y hacia detrás). Ejemplo: "sometemos".
		 */

		// ana
		// abba
		
		String str = "sometemos";
		
		String palabraRevertida = "";
		
		for(int i=str.length()-1; i>=0; i--) {
			palabraRevertida += str.charAt(i);
		}
		
//		System.out.println(str);
//		System.out.println(palabraRevertida);
		
		if(str.equals(palabraRevertida)) {
			System.out.println("Es palindromo");
		} else {
			System.out.println("NO es palindromo");
		}
		
	}

}
