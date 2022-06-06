package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


// Estudiante es una entidad de Hibernate que se mapea a la tabla estudiante de la base de datos

@Entity
@Table(name="estudiante")

// crea constructor con todos los parámetros
@AllArgsConstructor
public @Data class Estudiante {

	// @Id es una anotación que indica que el atributo id es clave primaria
	@Id
	// @GeneratedValue indica que el atributo id es autoincremental
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column indica el nombre de la columna a añadir en la tabla estudiante
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	public Estudiante() {}

}
