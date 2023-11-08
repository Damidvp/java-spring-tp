package com.example.demo.model;

import java.util.List;

import com.example.demo.enums.Sex;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "animals")
	private List<Person> person;
	
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

}
