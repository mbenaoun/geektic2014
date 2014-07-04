package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.bean.Interet;

@Repository
public class InteretDao implements IInteretDao {
	
	@PersistenceContext
	private EntityManager em;
	

	public List<Interet> findAllInteret(){
		String jpql = "SELECT i FROM Interet i";
		TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);
		return query.getResultList();
	}
}
