package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	private List<String> randomFirstnames = new ArrayList<>();
	private List<String> randomLastnames = new ArrayList<>();
	
	@Override
	public void deletePersonsWithoutAnimal() {
		// TODO Auto-generated method stub
		em.createQuery("DELETE FROM Person p WHERE SIZE(p.animals) = 0").executeUpdate();
	}

	@Override
	public void createPersonEntities(Integer numberOfEntities) {
		// TODO Auto-generated method stub
		createLists();
		for(int i=0; i<numberOfEntities; i++) {
			Person person = new Person();
			Integer randomIndexFirstname = new Random().nextInt(randomFirstnames.size());
			Integer randomIndexLastname = new Random().nextInt(randomLastnames.size());
			Integer randomAge = new Random().nextInt(65) + 15;
			
			person.setFirstname(randomFirstnames.get(randomIndexFirstname));
			person.setLastname(randomLastnames.get(randomIndexLastname));
			person.setAge(randomAge);

			em.persist(person);
		}
	}
	
	private void createLists() {
		randomFirstnames.add("Arno");
		randomFirstnames.add("Spaghetti");
		randomFirstnames.add("Sula");
		randomFirstnames.add("Ava");
		randomFirstnames.add("Giiu");
		randomFirstnames.add("Kuro");
		
		randomLastnames.add("Camoa");
		randomLastnames.add("Joe");
		randomLastnames.add("Cronim");
		randomLastnames.add("Stonsen");
		randomLastnames.add("Ehra");
		randomLastnames.add("Logia");
	}

	@Override
	public void adoptAnimalForPerson(Person person, Animal animal) {
		// TODO Auto-generated method stub
		person.addAnimal(animal);
		em.persist(person);
	}
	
}
