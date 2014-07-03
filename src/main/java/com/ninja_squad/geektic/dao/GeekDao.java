package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.bean.Geek;
import com.ninja_squad.geektic.bean.Interet;

@Repository
public class GeekDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Geek> findGeekByCriteria(String unSexe, String unInteret){
		String jpql = "SELECT g FROM Geek g"
				+ "join Interet i"
				+ "WHERE g.unSexe =:unSexe AND i.unInteret =: unInteret";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);		
		query.setParameter("unSexe", unSexe);
		query.setParameter("unInteret", unInteret);
		return query.getResultList();		
	}

	public List<Geek> findAllGeeks(){
		String jpql = "SELECT g FROM Geek g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();		
	}
	
	public List<Interet> findAllInteret(){
		String jpql = "SELECT i FROM Interet i";
		TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);
		return query.getResultList();
	}
}