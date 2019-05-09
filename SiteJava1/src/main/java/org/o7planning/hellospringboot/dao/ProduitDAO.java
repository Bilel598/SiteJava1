package org.o7planning.hellospringboot.dao;

import java.util.List;

import org.o7planning.hellospringboot.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDAO extends JpaRepository<Produit, Long> {
	
	@Query("select p from Produit p where p.categorie.idcat = :idcat")
	public List<Produit> produitByIdcat(@Param("idcat")long idcat);

}
