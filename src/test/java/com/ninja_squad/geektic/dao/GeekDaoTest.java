package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.bean.Geek;

public class GeekDaoTest extends BaseDaoTest{
	@Autowired
	private GeekDao monGeekDao;

	@Before
	public void populateDatabase() {
		Operation operation = Operations.sequenceOf(Operations.deleteAllFrom( "GEEK_CENTRES_INTERET","GEEK", "CENTRES_INTERET"),
				Operations.insertInto("GEEK")
				.columns("ID_GEEK", "NOM_GEEK", "PRENOM_GEEK", "AGE_GEEK", "SEXE_GEEK", "MAIL_GEEK", "PATHAVATAR_GEEK")
				.values(1, "jacques", "paul", 23, "M", "jp@hotmail.fr", "gerfghr")
				.values(2, "popo", "pipi", 23, "F", "pp@hotmail.fr", "geppprfghr")
				.values(3, "trtr", "trttr", 23, "M", "tt@hotmail.fr", "tttreter")
				.build(),
				Operations.insertInto("CENTRES_INTERET")
				.columns("ID_INTERET", "INTERET")
				.values(0, "Developpement Objet C#")
				.values(1, "Developpement Objet Java")
				.build(),
				Operations.insertInto("GEEK_CENTRES_INTERET")
				.columns("ID_GEEK", "ID_INTERET")
				.values(1, 0)
				.values(1, 1)
				.values(2, 0)
				.values(3, 1)
				.build()); // TODO define your operations here.
		DbSetup dbSetup = new DbSetup(destination, operation);
		dbSetup.launch();
	}
	@Test
	public void testGetAllGeeks(){
		List<Geek> list = monGeekDao.findAllGeeks();
		assertEquals(3, list.size());
	}
	@Test
	public void testGetGeeksByCiteria() {
		List<Geek> list = monGeekDao.findGeekByCriteria("M", 0);
		assertEquals(1, list.size());
		assertEquals(1, list.get(0).getUnIdGeek());
		assertEquals(2, list.get(0).getMesInterets().size());
		// implement your test here, by calling the exampleDao method to test.
	}
	
	@Test
	public void testGetOneGeek(){
		Geek unGeek = monGeekDao.findOneGeek(1);
		assertEquals("jacques", unGeek.getUnNom());
	}
}
