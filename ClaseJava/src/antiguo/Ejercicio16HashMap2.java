package antiguo;
import java.util.HashMap;

public class Ejercicio16HashMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Ejercicio: escribe un programa que dado dos HashMap compruebe cuántas claves
		 * de uno de los HashMap coinciden con los valores del otro HashMap.
		 */
		
		HashMap<String, String> capitales1 = new HashMap<String, String>();
		HashMap<String, String> capitales2 = new HashMap<String, String>();
		
		capitales1.put("Portugal", "Lisboa");
		capitales1.put("Italia", "Roma");
		capitales1.put("Noruega", "Oslo");
		
		capitales2.put("Lisboa", "Portugal");
		capitales2.put("París", "Francia");
		capitales2.put("Roma", "Italia");
		
		int contador = 0;
		for(String clave : capitales1.keySet()) {
			if(capitales2.containsValue(clave)) {
				contador++;
			}
		}		
		System.out.println(contador);

	}

}
