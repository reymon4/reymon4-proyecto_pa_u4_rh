package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ciudadano> buscar() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("Select * from ciudadano_p", Ciudadano.class);

		return query.getResultList();
	}

}
