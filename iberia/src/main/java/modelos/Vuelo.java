package modelos;

import java.time.LocalTime;

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

@AllArgsConstructor
@Entity
@Table(name="vuelo")
public @Data class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "origen")
	private String origen;
	
	@Column(name = "destino")
	private String destino;
	
	@Column(name = "hora")
	private LocalTime hora;
	
	@Column(name = "numero_vuelo")
	private String numeroVuelo;
	
	@Column(name = "id_piloto")
	private int idPiloto;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
	@JoinColumn(name="avion_id")
	private Avion avion;
	
	
	public Vuelo() {}

	public Vuelo(int id, String origen, String destino, LocalTime hora, String numeroVuelo, int idPiloto) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.hora = hora;
		this.numeroVuelo = numeroVuelo;
		this.idPiloto = idPiloto;
	}
}
