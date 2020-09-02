package com.rab3tech.dao.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles_tbl")
public class Role {
	private int rid;
	private String name;
	private String description;
	
	private Set<Login> logins;
	
	public Role() {}
		
	public Role(int rid, String name, String description) {
		super();
		this.rid = rid;
		this.name = name;
		this.description = description;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "rid"), inverseJoinColumns = @JoinColumn(name = "loginid"))
	public Set<Login> getLogins() {
		return logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Column(length=30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleEntity [rid=" + rid + ", name=" + name + ", description=" + description + "]";
	}

}
