package modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


// Estudiante es una entidad de Hibernate que se mapea a la tabla estudiante de la base de datos

@Entity
@Table(name="curso")

// crea constructor con todos los parámetros
@AllArgsConstructor
public @Data class Curso {

	// @Id es una anotación que indica que el atributo id es clave primaria
	@Id
	// @GeneratedValue indica que el atributo id es autoincremental
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column indica el nombre de la columna a añadir en la tabla estudiante
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
	@JoinColumn(name="docente_id")
	private Docente docente;
	
	
	public Curso() {}

}
