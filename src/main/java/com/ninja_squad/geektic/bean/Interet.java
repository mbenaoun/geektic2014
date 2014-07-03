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
	private int unIdInteret;
	
	@Column(name="INTERET")
	private String unInteret;

	public int getUnIdInteret() {
		return unIdInteret;
	}

	public void setUnIdInteret(int unIdInteret) {
		this.unIdInteret = unIdInteret;
	}

	public String getUnInteret() {
		return unInteret;
	}

	public void setUnInteret(String unInteret) {
		this.unInteret = unInteret;
	}
	
	
	
	
}
