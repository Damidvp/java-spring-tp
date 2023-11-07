package com.example.demo.model;

import com.example.demo.enums.Sex;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Animal {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String color;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@ManyToOne
	private Species species;
	
	public Animal() {}

	public Animal(String color, String name, Sex sex, Species species) {
		this.color = color;
		this.name = name;
		this.sex = sex;
		this.species = species;
	}



	@Override
	public String toString() {
		return "Animal [id=" + id + ", color=" + color + ", name=" + name + ", sex=" + sex + ", species=" + species
				+ "]";
	}
}
