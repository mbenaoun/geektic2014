package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.bean.Geek;
import com.ninja_squad.geektic.bean.Interet;
import com.ninja_squad.geektic.dao.IGeekDao;
import com.ninja_squad.geektic.dao.IInteretDao;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {

	IGeekDao monGeekDao; 
	
	IInteretDao monInteretDao;
	
	@Autowired
	public GeekService(IGeekDao unGeekDao, IInteretDao unInteretDao){
		this.monGeekDao = unGeekDao;
		this.monInteretDao = unInteretDao;	
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{sexe}/{interet}")
	public List<Geek> getGeeksBySexe(@PathVariable("sexe") String leSexe, @PathVariable("interet") int unInteret){
		return this.monGeekDao.findGeekByCriteria(leSexe, unInteret);
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public Geek getOneGeek(@PathVariable("id") int unId){
		return this.monGeekDao.findOneGeek(unId);
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/interetsListe")
	public List<Interet> getAllInteret(){
		return this.monInteretDao.findAllInteret();
	}
}
