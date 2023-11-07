package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Species {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "common_name")
	private String commonName;
	@Column(name = "latin_name")
	private String latinName;
	
	public Species() {}
	
	public Species(String common_name, String latin_name) {
		super();
		this.commonName = common_name;
		this.latinName = latin_name;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", common_name=" + commonName + ", latin_name=" + latinName + "]";
	}
	
	
}
