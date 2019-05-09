package org.o7planning.hellospringboot.services;

import java.util.List;

import org.o7planning.hellospringboot.dao.CategorieDAO;
import org.o7planning.hellospringboot.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategorieService {
	@Autowired
	private CategorieDAO categorieDAO;

	public List<Categorie> listDesCategorie(){
		return categorieDAO.findAll();
	}
	public Categorie chercherUneCat(Long id) {
		return categorieDAO.findById(id).get();
	}
	public void delete(Categorie c) {
		categorieDAO.delete(c);
	}

	public void save(Categorie categorie) {
		categorieDAO.save(categorie);
	}

}
