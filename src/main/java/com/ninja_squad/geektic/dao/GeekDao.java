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

	public List<Geek> findGeekByCriteria(String unSexe, int unIdInteret){
		String jpql = "SELECT distinct g FROM Geek g "
				+ "left join fetch g.mesInterets mi "
				+ "inner join g.mesInterets i "
				+ "WHERE g.unSexe =:unSexe AND i.unIdInteret =:unIdInteret";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);		
		query.setParameter("unSexe", unSexe);
		query.setParameter("unIdInteret", unIdInteret);
		return query.getResultList();		
	}

	public List<Geek> findAllGeeks(){
		String jpql = "SELECT g FROM Geek g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();		
	}
	
}
