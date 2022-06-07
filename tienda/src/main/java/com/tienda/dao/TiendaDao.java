package com.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tienda.modelos.Tienda;

import net.bytebuddy.asm.Advice.This;

@Repository
public class TiendaDao {

	private EntityManager entityManager;
	
	@Autowired
	public TiendaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void guardar(Tienda tienda) {
		Session session = this.entityManager.unwrap(Session.class);
		session.save(tienda);
	}

	
	@Transactional
	public List<Tienda> obtener() {
		Session session = this.entityManager.unwrap(Session.class);
		List<Tienda> tiendas = session.createQuery("from Tienda", Tienda.class).getResultList();
		System.out.println(tiendas);
		return tiendas;
	}

	@Transactional
	public Tienda obtenerPorId(int id) {
		Session session = this.entityManager.unwrap(Session.class);
		Tienda tienda = session.get(Tienda.class, id);
		return tienda;
	}


	@Transactional
	public void actualizar(Tienda tienda) {
		Session session = this.entityManager.unwrap(Session.class);
		session.saveOrUpdate(tienda);
	}

	@Transactional
	public void eliminarPorId(int id) {
		Session session = this.entityManager.unwrap(Session.class);
		session.remove(this.obtenerPorId(id));		
	}
}
