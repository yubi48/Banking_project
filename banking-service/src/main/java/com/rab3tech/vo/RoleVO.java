package com.rab3tech.vo;

import java.sql.Timestamp;

public class RoleVO {
	private int id;
	private String name;
	private String description;
	private Timestamp doe;
	private Timestamp dom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public Timestamp getDom() {
		return dom;
	}

	public void setDom(Timestamp dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "RoleVO [id=" + id + ", name=" + name + ", description=" + description + ", doe=" + doe + ", dom=" + dom
				+ "]";
	}

}
