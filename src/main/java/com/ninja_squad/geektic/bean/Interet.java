package com.ninja_squad.geektic.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CENTRES_INTERET")
public class Interet {
	
	@Id
	@Column(name="ID_INTERET")
	public int unIdInteret;
	
	@Column(name="INTERET")
	public String unInteret;
}
