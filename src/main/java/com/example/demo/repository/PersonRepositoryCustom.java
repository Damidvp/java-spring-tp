package com.example.demo.repository;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;

public interface PersonRepositoryCustom {
	
	void deletePersonsWithoutAnimal();
	void createPersonEntities(Integer numberOfEntities);
	
	void adoptAnimalForPerson(Person person, Animal animal);
	void giveAnimalsToRandomPersons(Integer numberOfAdoptions);
}
