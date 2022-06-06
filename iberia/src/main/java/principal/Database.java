package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Avion;
import modelos.Base;
import modelos.Miembro;
import modelos.Piloto;
import modelos.Vuelo;

public class Database {

	private Connection conexion = null;
//	private Session session = null;
	private SessionFactory factory = null;
	
	public Database() {
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/iberia", "iberia", "iberia");
			
			this.factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Avion.class)
					.addAnnotatedClass(Base.class)
					.addAnnotatedClass(Miembro.class)
					.addAnnotatedClass(Piloto.class)
					.addAnnotatedClass(Vuelo.class)
					.buildSessionFactory();
			
			// creación de un objeto de tipo Session a partir del SessionFactory
			
			System.out.println("Se abre la sesión de Hibernate");
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertarAvion(Avion avion) {
		
		Session session = factory.getCurrentSession();			
		session.beginTransaction();
		session.save(avion);
		session.getTransaction().commit();
		
//		try {
//			Statement instruccion = conexion.createStatement();
//
//			String sql = String.format("INSERT INTO avion (tipo, codigo) " + 
//					"VALUES ('%s','%s')",
//					avion.getTipo(), avion.getCodigo());
//
//			int registrosInsertados = instruccion.executeUpdate(sql);
//			if (registrosInsertados == 1) {
//				System.out.println("Avión insertado correctamente");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void insertarPiloto(Piloto piloto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(piloto);
		session.getTransaction().commit();
		
//		try {
//			Statement instruccion = conexion.createStatement();
//
//			String sql = String.format("INSERT INTO piloto (codigo, nombre, horas_de_vuelo) " + 
//					"VALUES ('%s', '%s', %d)",
//					piloto.getCodigo(), piloto.getNombre(), piloto.getHorasDeVuelo());
//
//			int registrosInsertados = instruccion.executeUpdate(sql);
//			if (registrosInsertados == 1) {
//				System.out.println("Piloto insertado correctamente");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void insertarMiembro(Miembro miembro) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(miembro);
		session.getTransaction().commit();
		
//		try {
//			Statement instruccion = conexion.createStatement();
//
//			String sql = String.format("INSERT INTO miembro (codigo, nombre) " + 
//					"VALUES ('%s', '%s')",
//					miembro.getCodigo(), miembro.getNombre());
//
//			int registrosInsertados = instruccion.executeUpdate(sql);
//			if (registrosInsertados == 1) {
//				System.out.println("Miembro insertado correctamente");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	public void insertarBase(Base base) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(base);
		session.getTransaction().commit();
	}
	


	public void insertarVuelo(Vuelo vuelo) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(vuelo);
		session.getTransaction().commit();		
	}

	public void vaciarTablas() {

		try {
			Statement instruccion = conexion.createStatement();
			
			// deshabilitar temporalmente la comprobación de clave foránea
			instruccion.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
		
			instruccion.executeUpdate("TRUNCATE avion");
			instruccion.executeUpdate("TRUNCATE piloto");
			instruccion.executeUpdate("TRUNCATE miembro");
			instruccion.executeUpdate("TRUNCATE vuelo");
			instruccion.executeUpdate("TRUNCATE base");
			instruccion.executeUpdate("TRUNCATE vuelo_miembro");
						
			// habilitar la comprobación de clave foránea
			instruccion.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Avion obtenerAvionPorId(int idAvion) {
		
		// obtener el avion con el id de idAvion
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Avion avion = session.get(Avion.class, idAvion);
		session.getTransaction().commit();		
		return avion;
	}

	public Base obtenerBasePorId(int idBase) {

		// obtener el base con el id de idBase
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Base base = session.get(Base.class, idBase);
		session.getTransaction().commit();		
		return base;
	}

	public void actualizarAvion(Avion avion) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(avion);
		session.getTransaction().commit();
	}

	public Piloto obtenerPilotoPorId(int idPiloto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Piloto piloto = session.get(Piloto.class, idPiloto);
		session.getTransaction().commit();		
		return piloto;
	}
	
}
