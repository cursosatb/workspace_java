package com.tienda.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="cliente")
@AllArgsConstructor
public @Data class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="saldo")
	private double saldo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "tienda_id")
	private Tienda tienda;
	
	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL}, orphanRemoval = true)
	private List<Articulo> carrito;
	
	public Cliente() {}
}
