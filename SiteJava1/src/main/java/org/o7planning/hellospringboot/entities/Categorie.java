package org.o7planning.hellospringboot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 9169274950634434115L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long idcat;


private String nomCat;




public Categorie(long idcat, String nomCat) {
	super();
	this.idcat = idcat;
	this.nomCat = nomCat;
}




public long getIdcat() {
	return idcat;
}




public void setIdcat(long idcat) {
	this.idcat = idcat;
}




public String getNomCat() {
	return nomCat;
}




public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}




public Categorie() {
	super();
}




@Override
public String toString() {
	return "Categorie [idcat=" + idcat + ", nomCat=" + nomCat + "]";
}



}
