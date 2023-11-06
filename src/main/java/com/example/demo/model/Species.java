package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Species {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String common_name;
	private String latin_name;
	
	public Species() {}
	
	public Species(String common_name, String latin_name) {
		super();
		this.common_name = common_name;
		this.latin_name = latin_name;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", common_name=" + common_name + ", latin_name=" + latin_name + "]";
	}
	
	
}
