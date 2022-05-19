package antiguo;

import java.util.HashMap;

public class Ejercicio15HashMap1 {

	public static void main(String[] args) {
		
		/*
		 * Ejercicio: escribe un programa que inserte pares clave/valor en un HashMap y
		 * los muestre en pantalla mediante un forEach, siendo las claves de tipo
		 * Boolean y los valores de tipo String.
		 */
		
		HashMap <Boolean, String> map = new HashMap<Boolean, String>();
		map.put(true, "hola");
		map.put(true, "a");
		map.put(true, "b");
		map.put(true, "c");
		map.put(true, "d");
		map.put(false, "e");
		
		System.out.println(map.size());
	}
}
