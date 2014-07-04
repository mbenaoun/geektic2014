package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ninja_squad.geektic.bean.Geek;
import com.ninja_squad.geektic.bean.Interet;
import com.ninja_squad.geektic.config.AppConfig;
import com.ninja_squad.geektic.dao.IGeekDao;
import com.ninja_squad.geektic.dao.IInteretDao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class })
public class GeekServiceTest{
	private IGeekDao monDaoGeek; 
	private IInteretDao	monDaoInteret;
	private GeekService monService;
	
	
	@Before
	  public void setup() throws Exception {
		monDaoGeek = mock(IGeekDao.class);
		monDaoInteret = mock(IInteretDao.class);
	    monService = new GeekService(monDaoGeek, monDaoInteret);
	  }
	
	@Test
	public void getAGeekTest(){
		ArrayList<Interet> listDonneDurInteret = new ArrayList<Interet>();
		
		Geek unGeek = new Geek();
		unGeek.setUnIdGeek(0);
		unGeek.setUnNom("Ben aoun");
		unGeek.setUnPrenom("Mhemed");
		unGeek.setUnSexe("M");
		
		Interet unInteret = new Interet();
		unInteret.setUnIdInteret(0);
		unInteret.setUnInteret("Java");
		Interet unInteret1 = new Interet();
		unInteret1.setUnIdInteret(1);
		unInteret1.setUnInteret("c#");
		listDonneDurInteret.add(unInteret);
		listDonneDurInteret.add(unInteret1);
		
		unGeek.setMesInterets(listDonneDurInteret);
		
		when(monDaoGeek.findOneGeek(0)).thenReturn(unGeek);
		
		Geek unGeekService = monService.getOneGeek(0);
		
		assertEquals("Ben aoun", unGeekService.getUnNom());
		assertEquals(unGeek, unGeekService);
}
	
	@Test
	public void getListGeeksByCriteriaTest(){
		ArrayList<Geek> listeDonneesDur = new ArrayList<Geek>();
		ArrayList<Interet> listDonneDurInteret = new ArrayList<Interet>();
		
		Geek unGeek = new Geek();
		unGeek.setUnIdGeek(0);
		unGeek.setUnNom("Ben aoun");
		unGeek.setUnPrenom("Mhemed");
		unGeek.setUnSexe("M");
		Geek unGeek1 = new Geek();
		unGeek1.setUnIdGeek(1);
		unGeek1.setUnNom("Mat");
		unGeek1.setUnPrenom("Min");
		unGeek1.setUnSexe("M");
		
		Interet unInteret = new Interet();
		unInteret.setUnIdInteret(0);
		unInteret.setUnInteret("Java");
		
		listDonneDurInteret.add(unInteret);		
		unGeek.setMesInterets(listDonneDurInteret);
		unGeek1.setMesInterets(listDonneDurInteret);
		listeDonneesDur.add(unGeek);
		listeDonneesDur.add(unGeek1);
		
		when(monDaoGeek.findGeekByCriteria("M", 0)).thenReturn(listeDonneesDur);
		
		List<Geek> mesGeeksService = monService.getGeeksBySexe("M", 0);
		
		assertEquals(2, mesGeeksService.size());
		assertEquals(listeDonneesDur, mesGeeksService);
	}
	
	@Test
	public void getListeInteretsTest(){
		ArrayList<Interet> listDonneDurInteret = new ArrayList<Interet>();
		
		Interet unInteret = new Interet();
		unInteret.setUnIdInteret(0);
		unInteret.setUnInteret("Java");
		Interet unInteret1 = new Interet();
		unInteret1.setUnIdInteret(1);
		unInteret1.setUnInteret("c#");
		listDonneDurInteret.add(unInteret);
		listDonneDurInteret.add(unInteret1);
		
		when(monDaoInteret.findAllInteret()).thenReturn(listDonneDurInteret);
		
		List<Interet> mesInteretsService = monService.getAllInteret();
		
		assertEquals(2, mesInteretsService.size());
		assertEquals(mesInteretsService, listDonneDurInteret);		
	}
}
