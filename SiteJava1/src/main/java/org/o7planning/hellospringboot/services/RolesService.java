package org.o7planning.hellospringboot.services;

import java.util.List;

import org.o7planning.hellospringboot.dao.RoleDao;
import org.o7planning.hellospringboot.entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
	@Autowired
	private RoleDao roleDAO;

	public List<Roles>listDesRoles(){
		return roleDAO.findAll();	
	}

	public Roles chercherUnRole(Long id) {
		return roleDAO.findById(id).get();
	}
	
	public Roles chercherUnRoleParRole(String role) {
		return roleDAO.findOneByRole(role);
	}
	
	public void save(Roles role) {
		roleDAO.save(role);
	}
}
