package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.bean.Geek;
import com.ninja_squad.geektic.bean.Interet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class ExampleDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
     @Autowired
    private GeekDao exampleDao;

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
    public void testSomeDaoMethod() {
    	List<Geek> list = exampleDao.findGeekByCriteria("M", 0);
    	assertEquals(1, list.size());
    	assertEquals(1, list.get(0).getUnIdGeek());
    	assertEquals(2, list.get(0).getMesInterets().size());
        // implement your test here, by calling the exampleDao method to test.
    }
}
