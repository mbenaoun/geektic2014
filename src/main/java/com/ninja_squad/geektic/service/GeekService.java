package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.bean.Geek;
import com.ninja_squad.geektic.dao.GeekDao;

@RestController
@Transactional
@RequestMapping("/api/hello")
public class GeekService {

	GeekDao monGeekDao; 
	
	@Autowired
	public GeekService(GeekDao unGeekDao){
		this.monGeekDao = unGeekDao;
	}
	
	@RequestMapping(value = "geek/{sexe}/{interet}")
	public List<Geek> getGeeksBySexe(@PathVariable("sexe") String leSexe, @PathVariable("interet") String unInteret){
		return this.monGeekDao.findGeekByCriteria(leSexe, unInteret);
	}
}
