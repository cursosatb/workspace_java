package antiguo;

import java.util.HashMap;

public class Main6 {

	public static void main(String[] args) {
		
		HashMap<String, String> capitales = new HashMap<String, String>();
		
		// agregar elementos
		capitales.put("Francia", "París");
		capitales.put("España", "Madrid");
		capitales.put("Mozambique", "Maputo");
		
		// elimina un elemento
//		capitales.remove("España");
		
		// extraer un elemento y lo muestra por pantalla
//		System.out.println(capitales.get("Francia"));
		
		// comprueba si existe una determina clave
//		System.out.println(capitales.containsKey("España"));
//		System.out.println(capitales.containsKey("Francia"));
		
		capitales.put("Francia", "Disney");
		
//		System.out.println(capitales);
//		System.out.println(capitales.size());
		
		// iterar HashMap por las claves
		for(String clave: capitales.keySet()) {
			System.out.println(clave + ": " + capitales.get(clave));
		}
		
		

	}

}
