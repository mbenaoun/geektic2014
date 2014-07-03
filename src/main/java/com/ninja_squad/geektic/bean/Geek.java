package com.ninja_squad.geektic.bean;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="GEEK")
public class Geek {
	@Id
	@Column(name="ID_GEEK")
	public int unIdGeek;

	@Column(name="NOM_GEEK")
	public String unNom;

	@Column(name="PRENOM_GEEK") 
	public String unPrenom;

	@Column(name="AGE_GEEK")
	public int unAge;

	@Column(name="SEXE_GEEK")
	public String unSexe;

	@Column(name="MAIL_GEEK")
	public String unMail;

	@Column(name="PATHAVATAR_GEEK")
	public String unTreeAvatar;
	
	@ManyToMany
	@JoinTable(
		      name="GEEK_CENTRES_INTERET",
		      joinColumns={@JoinColumn(name="ID_GEEK", referencedColumnName="unIdGeek")},
		      inverseJoinColumns={@JoinColumn(name="ID_INTERET", referencedColumnName="unIdInteret")})
	public List<Interet> mesInterets;
}
