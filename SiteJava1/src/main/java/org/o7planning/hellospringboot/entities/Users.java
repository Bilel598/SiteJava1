package org.o7planning.hellospringboot.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")

public class Users implements Serializable {

	private static final long serialVersionUID = 6897168687609749979L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_user;
	private String login;
	private String pass;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "Users_Roles", joinColumns = {
			@JoinColumn(name = "username", referencedColumnName = "login") }, inverseJoinColumns = {
					@JoinColumn(name = "role", referencedColumnName = "role") })
	private List<Roles> role;

	public Users(Long id_user, String login, String pass, List<Roles> role) {
		super();
		this.id_user = id_user;
		this.login = login;
		this.pass = pass;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id_user=" + id_user + ", login=" + login + ", pass=" + pass + ", role=" + role + "]";
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}

	public Users() {
		super();
	}

}