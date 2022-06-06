package myapp;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	private static String sha3(String input) {
		MessageDigest crypt;
		try {
			crypt = MessageDigest.getInstance("SHA3-512");
			crypt.update(input.getBytes(StandardCharsets.UTF_8));

			byte[] bytes = crypt.digest();
			BigInteger bi = new BigInteger(1, bytes);
			String digest = String.format("%0" + (bytes.length << 1) + "x", bi);

			return digest;
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. Registrar un nuevo usuario: solicita el nombre de usuario, password y
		 * correo 2. Autenticación 3. Cambiar contraseña 4. Listar usuarios 5. Eliminar
		 * usuario 6. Salir
		 */

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp?allowMultiQueries=true", "myapp", "myapp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Scanner keyboard = new Scanner(System.in);

		int eleccion = 6;

		do {

			System.out.println("---");
			System.out.println("1. Registrar un nuevo usuario");
			System.out.println("2. Autenticación");
			System.out.println("3. Cambiar password");
			System.out.println("4. Listar usuarios");
			System.out.println("5. Eliminar usuario");
			System.out.println("6. Salir");
			System.out.println("---");
			System.out.print("Introduzca elección: ");
			eleccion = keyboard.nextInt();

			if (eleccion == 1) {
				Main.registarNuevoUsuario(keyboard, conexion);
			} else if (eleccion == 2) {
				Main.autenticacion(keyboard, conexion);
			} else if (eleccion == 3) {
				Main.cambiarPassword(keyboard, conexion);
			} else if (eleccion == 4) {
				Main.listarUsuarios(conexion);
			} else if (eleccion == 5) {
				Main.eliminarUsuario(keyboard, conexion);
			} else if (eleccion == 6) {
				System.out.println("Salir");
			}

		} while (eleccion != 6);

		keyboard.close();
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void registarNuevoUsuario(Scanner keyboard, Connection conexion) {

		/*
		 * Solicitud de datos al usuario
		 */

		System.out.println("Usuario: ");
		String usuario = keyboard.next();

		System.out.println("Password: ");
		String password = keyboard.next();

		System.out.println("Correo: ");
		String correo = keyboard.next();

		/*
		 * Validación
		 */

		if (usuario.length() < 4) {
			System.err.println("Nombre de usuario demasiado corto");
			return;
		}

		if (password.length() < 8) {
			System.err.println("Password demasiado corto");
			return;
		}

		if (!correo.contains("@")) {
			System.err.println("No es un correo válido");
			return;
		}

		/*
		 * Insertar los datos del usuario en la base de datos
		 */
		try {
			Statement instruccion = conexion.createStatement();

//			String sql = "INSERT INTO usuario (usuario, password, correo) VALUES ('" + usuario + "', " 
//					+ "'" + password + "','" + correo + "')";

			String passwordSHA3 = sha3(password);
			String sql = String.format("INSERT INTO usuario (usuario, password, correo) " + "VALUES ('%s', '%s', '%s')",
					usuario, passwordSHA3, correo);

			int registrosInsertados = instruccion.executeUpdate(sql);
			if (registrosInsertados == 1) {
				System.out.println("Usuario insertado correctamente");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void autenticacion(Scanner keyboard, Connection conexion) {

		/*
		 * Solicitud de datos al usuario
		 */

		System.out.println("Usuario: ");
		String usuario = keyboard.next();

		System.out.println("Password: ");
		String password = keyboard.next();

		try {

			String sql = "SELECT password FROM usuario WHERE usuario=?";
			PreparedStatement instruccion = conexion.prepareStatement(sql);

			instruccion.setString(1, usuario);

			ResultSet result = instruccion.executeQuery();
			if (!result.next()) {
				System.out.println("No existe el usuario");
				return;
			}

			// si existe, entonces hay que comprobar las contraseñas
			String passwordGuardada = result.getString("password");

			if (sha3(password).equals(passwordGuardada)) {
				System.out.println("Autenticación correcta");
			} else {
				System.out.println("Autenticación INCORRECTA");

			}

			/*
			 * VULNERABLE A ATAQUES DE INYECCIÓN SQL Statement instruccion =
			 * conexion.createStatement();
			 * 
			 * String sql = String.format("SELECT * FROM usuario " +
			 * "WHERE usuario='%s' AND password='%s'", usuario, password);
			 * 
			 * ResultSet result = instruccion.executeQuery(sql);
			 */

			// si la autenticación es correcta, result debe devolver un registro
			// si la autenticación no es correcta, result no devuelve ningún registro

			// si next() devuelve true, entonces hay al menos un registro
			// si next() devuelve false, entonces no hay ningún registro

//			if(result.next()) {
//				System.out.println("¡Autenticación correcta!");
//			} 
//			else {	
//				System.out.println("¡Autenticación INCORRECTA!");
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	private static void cambiarPassword(Scanner keyboard, Connection conexion) {

		/*
		 * Solicitud de datos al usuario
		 */
		System.out.println("Usuario: ");
		String usuario = keyboard.next();

		System.out.println("Nuevo password: ");
		String nuevoPassword = keyboard.next();

		// buscar en la base de datos si existe un usuario con el nombre de usuario
		// introducido arriba
		String sql = "SELECT password FROM usuario WHERE usuario=?";

		try {
			PreparedStatement instruccion = conexion.prepareStatement(sql);

			instruccion.setString(1, usuario);

			ResultSet result = instruccion.executeQuery();
			if (!result.next()) {
				System.out.println("No existe el usuario");
				return;
			}

			// en este punto del programa sabemos que el usuario existe y por tanto, podemos
			// cambiar la contraseña
			String nuevoPasswordSHA3 = Main.sha3(nuevoPassword);

			sql = String.format("UPDATE usuario SET password='%s' WHERE usuario='%s'", nuevoPasswordSHA3, usuario);

			int registrosActualizados = instruccion.executeUpdate(sql);
			if (registrosActualizados == 1) {
				System.out.println("Usuario actualizado correctamente");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

	private static void listarUsuarios(Connection conexion) {

		try {

			String sql = "SELECT id, usuario, correo FROM usuario";

			PreparedStatement instruccion = conexion.prepareStatement(sql);

			// aquí se realiza la consulta SELECT a la base de datos
			ResultSet resultados = instruccion.executeQuery(sql);

			// mientras que hay resultados (next devuelve true), sigo iterando
			// cuando next devuelva false, no hay más datos que recorrer
			while (resultados.next()) {

				int id = resultados.getInt("id");
				String usuario = resultados.getString("usuario");
				String correo = resultados.getString("correo");

				System.out.println(id + ". " + usuario + ":" + correo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static void eliminarUsuario(Scanner keyboard, Connection conexion) {
		// TODO Auto-generated method stub

		/*
		 * Solicitud de datos al usuario
		 */
		System.out.println("Usuario a eliminar: ");
		String usuario = keyboard.next();

		// buscar en la base de datos si existe un usuario con el nombre de usuario
		// introducido arriba
		String sql = "SELECT password FROM usuario WHERE usuario=?";

		try {
			PreparedStatement instruccion = conexion.prepareStatement(sql);

			instruccion.setString(1, usuario);

			ResultSet result = instruccion.executeQuery();
			
			// si no existe, no podemos borrar el usuario
			if (!result.next()) {
				System.out.println("No existe el usuario");
				return;
			}

			// en este punto del programa sabemos que el usuario existe y por tanto, podemos
			// eliminarlo

			sql = String.format("DELETE FROM usuario WHERE usuario='%s'", usuario);

			int registrosEliminados = instruccion.executeUpdate(sql);
			if (registrosEliminados == 1) {
				System.out.println("Usuario eliminado correctamente");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

}
