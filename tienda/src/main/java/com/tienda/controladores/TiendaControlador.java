package com.tienda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.dao.TiendaDao;
import com.tienda.modelos.Tienda;
import com.tienda.vistas.DataEmpty;
import com.tienda.vistas.Respuesta;

@RestController
@RequestMapping("/tienda")
public class TiendaControlador {
	
	private TiendaDao tiendaDao;
	
	@Autowired
	public TiendaControlador(TiendaDao tiendaDao) {
		this.tiendaDao = tiendaDao;
	}

	@PostMapping("/insertar")
	public Respuesta insertarTienda(@RequestBody Tienda tienda) {
		this.tiendaDao.guardar(tienda);
		return new Respuesta(true, "", new DataEmpty());
	}
	
	
	// devuelve un array JSON con todas las tiendas
	@GetMapping("/obtener")
	public List<Tienda> obtenerTiendas() {
		return this.tiendaDao.obtener();
	}
	
	// devuelve un objeto JSON con la tienda que solicite el cliente (a partir de su id)
	@GetMapping("/obtener/{id}")
	public Tienda obtenerTienda(@PathVariable int id) {
		return this.tiendaDao.obtenerPorId(id);
//		return new ResponseEntity<>(new DataEmpty(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/actualizar")
	public Respuesta actualizarTienda(@RequestBody Tienda tienda) {
		
		Tienda tiendaExistente = this.tiendaDao.obtenerPorId(tienda.getId());
		if(tiendaExistente == null) {
			return new Respuesta(false, "No existe la tienda con el id " + tienda.getId(), new DataEmpty());
		}
		
		if(tienda.getNombre() != null) {
			tiendaExistente.setNombre(tienda.getNombre());
		}
		
		if(tienda.getDireccion() != null) {
			tiendaExistente.setDireccion(tienda.getDireccion());
		}
		
		if(tienda.getTelefono() != null) {
			tiendaExistente.setTelefono(tienda.getTelefono());
		}		
		
		this.tiendaDao.actualizar(tiendaExistente);		
		return new Respuesta(true, "", new DataEmpty());
	}
	
	@GetMapping("/eliminar/{id}")
	public Respuesta eliminarTienda(@PathVariable int id) {
		
		Tienda tiendaExistente = this.tiendaDao.obtenerPorId(id);
		if(tiendaExistente == null) {
			return new Respuesta(false, "No existe la tienda con el id " + id, new DataEmpty());
		}
		
		this.tiendaDao.eliminarPorId(id);
		return new Respuesta(true, "", new DataEmpty());
	}
	
}
