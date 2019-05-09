package org.o7planning.hellospringboot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Produit implements Serializable{

	private static final long serialVersionUID = -225128938017979487L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private float prix;

@ManyToOne
private Categorie categorie;


public Categorie getCategorie() {
	return categorie;
}

public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public float getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

public Produit(Long id, String nom, float prix) {
	super();
	this.id = id;
	this.nom = nom;
	this.prix = prix;
}

public Produit() {
	super();

}

@Override
public String toString() {
	return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", categorie=" + categorie + "]";
}



}
