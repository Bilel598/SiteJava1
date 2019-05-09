package org.o7planning.hellospringboot.services;

import java.util.List;

import org.o7planning.hellospringboot.dao.ProduitDAO;
import org.o7planning.hellospringboot.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProduitService {
@Autowired
private ProduitDAO produitDAO;	



public Produit chercherUnProduit(Long id) {
	return produitDAO.findById(id).get();
}
public List<Produit> listDesProduit(){
	return produitDAO.findAll();
}

public void delete(Produit p) {
	produitDAO.delete(p);
}

public Produit save(Produit produit) {
	return produitDAO.save(produit);
	
}

		
public List<Produit> listProduitParCategorie(Long idcat){
	return produitDAO.produitByIdcat(idcat);
}

}
