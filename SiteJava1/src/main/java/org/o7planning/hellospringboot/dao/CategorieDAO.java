package org.o7planning.hellospringboot.dao;

import org.o7planning.hellospringboot.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDAO extends JpaRepository<Categorie, Long> {
	
}
