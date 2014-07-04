package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.geektic.bean.Geek;

public interface IGeekDao {
	public List<Geek> findGeekByCriteria(String unSexe, int unIdInteret);
	
	public List<Geek> findAllGeeks();
	
	public Geek findOneGeek(int monId);
}
