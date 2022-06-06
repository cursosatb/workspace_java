package principal;

import java.time.LocalTime;

import modelos.Vuelo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Iberia iberia = new Iberia();
		
//		iberia.vaciarBaseDeDatos();
		iberia.insertarDatos();
		
		// el primer parámetro es el id del avión y el segundo parámetro es el id de la base
		iberia.llevarAvionABase(4, 8);
		iberia.llevarAvionABase(1, 1);
		iberia.llevarAvionABase(2, 1);
		iberia.llevarAvionABase(3, 1);
		iberia.llevarAvionABase(7, 1);
		
		// el primer parámetro es el id del avión, segundo el origen, tercero el destino
		// cuarto la hora, quinto el código del vuelo y sexto el identificador del piloto
		Vuelo vuelo = new Vuelo(0, "Madrid", "Roma", LocalTime.now(), "MA-RO", 1);
		iberia.volarAvion(1, vuelo);
		
		Vuelo vuelo2 = new Vuelo(0, "Nueva York", "Londres", LocalTime.now(), "NY-LO", 1);
		iberia.volarAvion(4, vuelo2);
		
		iberia.crearVuelosParaAvion();
	}

}
