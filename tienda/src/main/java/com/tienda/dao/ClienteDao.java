package com.tienda.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao {

	private EntityManager entityManager;

	@Autowired
	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
