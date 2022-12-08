package tn.enig.model;

import javax.persistence.*;

@Entity
public class Role {

	@Id
	private int Id;
	
	private String role;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
