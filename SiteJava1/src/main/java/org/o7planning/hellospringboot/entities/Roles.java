package org.o7planning.hellospringboot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = -353344619626524269L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_role;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	@Override
	public String toString() {
		return "Roles [id_role=" + id_role + ", role=" + role + "]";
	}

	public Roles(Long id_role, String role) {
		super();
		this.id_role = id_role;
		this.role = role;
	}

	public Roles() {
		super();
	}
	

}
