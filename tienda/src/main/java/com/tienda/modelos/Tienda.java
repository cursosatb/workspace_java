package com.tienda.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="tienda")
@AllArgsConstructor
public @Data class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "tienda", cascade = { CascadeType.ALL}, orphanRemoval = true)
	private List<Articulo> articulos;
	
	@OneToMany(mappedBy = "tienda", cascade = { CascadeType.ALL}, orphanRemoval = true)
	private List<Cliente> clientes;

	@Column(name="telefono")
	private Integer telefono;
	
	@Column(name="direccion")
	private String direccion;

	@Override
	public String toString() {
		return "Tienda [id=" + id + ", nombre=" + nombre + ", articulos=" + articulos + ", clientes=" + clientes
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
	public Tienda() {}

	public void agregarNuevosClientes(List<Cliente> nuevoClientes) {
		for(Cliente nuevoCliente : nuevoClientes) {
			this.clientes.add(nuevoCliente);
		}
		
	}
	
}
