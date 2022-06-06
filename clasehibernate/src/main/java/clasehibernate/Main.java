package clasehibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.javafaker.Faker;

import modelos.Curso;
import modelos.Docente;
import modelos.Estudiante;

public class Main {	

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		
		/*
	      creación del objeto SessionFactory. Hibernate buscará por defecto el archivo
	      hibernate.cfg.xml, aunque no se le indique, por lo que no es necesario establecerlo
	      como parámetro en el método configure
	    */
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Estudiante.class)
				.addAnnotatedClass(Docente.class)
				.addAnnotatedClass(Curso.class)
				.buildSessionFactory();
		
		// creación de un objeto de tipo Session a partir del SessionFactory
		Session session = factory.getCurrentSession();
		
//		// comenzar la transacción
		session.beginTransaction();
		
		Estudiante estudiante1 = new Estudiante(0, "Marcos", "Naranjo", 21);
		Estudiante estudiante2 = new Estudiante(0, "Felipe", "Gonzalez", 25);
		Estudiante estudiante3 = new Estudiante(0, "Ana", "Rubio", 25);
		
		// insertar los datos del estudiante en la tabla estudiante
		session.save(estudiante1);		
		session.save(estudiante2);		
		session.save(estudiante3);		
		
		Docente docente = new Docente(0, "Paquito", "Ochoa", "paquito@mail.com", new ArrayList<Curso>());
		session.save(docente);
		
		
		
		Docente docente2 = new Docente(0, "Marcos", "Aurelio", "marcos@mail.com", new ArrayList<Curso>());
		session.save(docente2);
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
//		Curso curso1 = new Curso(0, "Curso de Java", docente2);
		cursos.add(new Curso(0, "Curso de Linux", docente2));
		cursos.add(new Curso(0, "Curso de Kotlin", docente2));
		cursos.add(new Curso(0, "Curso de C++", docente2));
		cursos.add(new Curso(0, "Curso de Java", docente2));
		
		docente.setCursos(cursos);
//		
//		// obtener el estudiante con el id igual a 1
//		Estudiante estudianteSeleccionado = session.get(Estudiante.class, 1);
////		System.out.println(estudianteSeleccionado.getApellidos());
//		
//		// obtener todos los estudiantes que tengan 25 años
//		List<Estudiante> estudiantes = session.createQuery("FROM Estudiante WHERE edad=25", 
//				Estudiante.class).getResultList();
//		
//		// forEach
//		for (Estudiante estudiante : estudiantes) {
//			System.out.println(estudiante.getNombre());
//		}
//		
//		// obtener el estudiante con el id igual a 1
////		Estudiante estudianteSeleccionado = session.get(Estudiante.class, 1);
//		estudianteSeleccionado.setEdad(36);	//actualiza el campo edad al valor 36
//		
//		// eliminar el estudiante con el id igual a 1
//		session.delete(estudianteSeleccionado);
			
		// finaliza la transacción
		session.getTransaction().commit();
		
		// cierre del objeto SessionFactory
		factory.close();
		
	}
}
