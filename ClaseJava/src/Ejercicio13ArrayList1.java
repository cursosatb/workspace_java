import java.util.ArrayList;

public class Ejercicio13ArrayList1 {

	public static void main(String[] args) {

		/*
		 * Ejercicio: escribe un programa con un ArrayList que almacene los nombres
		 * de tres colores. A continuaci�n, crea otro ArrayList vac�o e inserta en �l
		 * todos los elementos del primer ArrayList mediante un forEach.
		 */
		
		ArrayList<String> colores = new ArrayList<String>();
		colores.add("azul");
		colores.add("rojo");
		colores.add("negro");		
//		System.out.println(colores);
		
		
		ArrayList<String> colores2 = new ArrayList<String>();
		
		// forEach para iterar un ArrayList
//		for(String color : colores) {
//			colores2.add(color);
//		}
		
		// for cl�sico
		for(int i=0; i<colores.size(); i++) {
			System.out.println(i + " " + colores.get(i));
			colores2.add(colores.get(i));
		}
		
		System.out.println(colores2);		
		
	}
}
