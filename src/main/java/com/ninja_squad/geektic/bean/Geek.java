package com.ninja_squad.geektic.bean;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="GEEK")
public class Geek {
	
	@Column(name="ID_GEEK")
	@Id
	private int unIdGeek;
	
	@Column(name="NOM_GEEK")
	private String unNom;
	
	@Column(name="PRENOM_GEEK")
	private String unPrenom;
	
	@Column(name="AGE_GEEK")
	private int unAge;
	
	@Column(name="SEXE_GEEK")
	private String unSexe;
	
	@Column(name="MAIL_GEEK")
	private String unMail;
	
	@Column(name="PATHAVATAR_GEEK")
	private String unTreeAvatar;
	
	@ManyToMany
	@JoinTable(
		      name="GEEK_CENTRES_INTERET",
		      joinColumns={@JoinColumn(name="ID_GEEK", referencedColumnName="ID_GEEK")},
		      inverseJoinColumns={@JoinColumn(name="ID_INTERET", referencedColumnName="ID_INTERET")})
	private List<Interet> mesInterets;

	public int getUnIdGeek() {
		return unIdGeek;
	}

	public void setUnIdGeek(int unIdGeek) {
		this.unIdGeek = unIdGeek;
	}

	public String getUnNom() {
		return unNom;
	}

	public void setUnNom(String unNom) {
		this.unNom = unNom;
	}

	public String getUnPrenom() {
		return unPrenom;
	}

	public void setUnPrenom(String unPrenom) {
		this.unPrenom = unPrenom;
	}

	public int getUnAge() {
		return unAge;
	}

	public void setUnAge(int unAge) {
		this.unAge = unAge;
	}

	public String getUnSexe() {
		return unSexe;
	}

	public void setUnSexe(String unSexe) {
		this.unSexe = unSexe;
	}

	public String getUnMail() {
		return unMail;
	}

	public void setUnMail(String unMail) {
		this.unMail = unMail;
	}

	public String getUnTreeAvatar() {
		return unTreeAvatar;
	}

	public void setUnTreeAvatar(String unTreeAvatar) {
		this.unTreeAvatar = unTreeAvatar;
	}

	public List<Interet> getMesInterets() {
		return mesInterets;
	}

	public void setMesInterets(List<Interet> mesInterets) {
		this.mesInterets = mesInterets;
	}
}
