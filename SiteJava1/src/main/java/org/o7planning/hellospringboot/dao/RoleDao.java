package org.o7planning.hellospringboot.dao;

import org.o7planning.hellospringboot.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Roles, Long>{

	Roles findOneByRole(String role);

}
