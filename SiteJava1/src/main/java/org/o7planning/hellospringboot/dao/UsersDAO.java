package org.o7planning.hellospringboot.dao;

import org.o7planning.hellospringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Long> {
	 Users findUsersByLogin(String login);
}
