package com.tienda.modelos;

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
@Table(name="articulo")
@AllArgsConstructor
public @Data class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private double precio;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "tienda_id")
	private Tienda tienda;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Articulo() {}
}
