package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String contenido = "Hola mundo";
		
		try {
			
			// inicialización del objeto de la clase FileWriter y contenido.txt es el nombre
			// del archivo
			FileWriter fileWriter = new FileWriter("contenido.txt");
			
			for (int i = 0; i < 5; i++) {
				// escribe en el archivo
				fileWriter.write(contenido);
			}
			
			// cierra el archivo
			fileWriter.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int a = 5;
		int b = 0;
//		System.out.println(a / b);
		
		try {
			String content = new String ( Files.readAllBytes( Paths.get("contjjjenido.txt") ) );
			System.out.println(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
