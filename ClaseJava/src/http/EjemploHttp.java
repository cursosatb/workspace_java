package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class EjemploHttp {

	public static void main(String[] args) {

		try {

			// crea el objeto HttpURLConnection a partir de un objeto de clase URL
//			URL url = new URL("https://www.marca.com/");
			URL url = new URL("https://swapi.dev/api/people/1");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// se establece el método GET de HTTP
			connection.setRequestMethod("GET");

			// se establece el valor del campo Accept de la cabecera HTTP
			connection.setRequestProperty("Accept", "application/json");

			// se establece la comunicación
			connection.connect();

			// lee los datos devueltos por el servidor
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder content = new StringBuilder();
			String line = in.readLine();
			while (line != null) {
				content.append(line);
				line = in.readLine();
			}

			// muestra los datos por pantalla
			System.out.println(content);

			// cerrar la conexión
			in.close();

			// obtiene el código de estado HTTP
			
			System.out.println("Código HTTP " + connection.getResponseCode());

		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
