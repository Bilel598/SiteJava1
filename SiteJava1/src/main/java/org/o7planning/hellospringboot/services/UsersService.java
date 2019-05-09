package org.o7planning.hellospringboot.services;

import java.util.List;

import org.o7planning.hellospringboot.dao.UsersDAO;
import org.o7planning.hellospringboot.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
@Autowired
private UsersDAO usersDAO;

public List<Users> listDesUsers(){
	return usersDAO.findAll();
}
public Users chercherUnUser(Long id) {
	return usersDAO.getOne(id);
}

public Users chercherUnUserByName(String name) {
	return usersDAO.findUsersByLogin(name);
}

public void delete(Users u) {
	usersDAO.delete(u);
}

public void save(Users users) {
	 usersDAO.save(users);
}
	
}
