package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enums.Sex;
import com.example.demo.model.Animal;
import com.example.demo.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest @Transactional
public class PersonRepositoryTest {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PersonRepository personRepo;
	
	Animal animal = new Animal();
	Person person1 = new Person();
	Person person2 = new Person();
	Person person3 = new Person();

	@BeforeEach
	public void insertData() {
		em.clear();
		
		animal.setColor("Rouge");
		animal.setName("Bubulle");
		animal.setSex(Sex.M);
		em.persist(animal);
		
		person1.setFirstname("Arno");
		person1.setLastname("Camoa");
		person1.setAge(22);
		person1.addAnimal(animal);
		em.persist(person1);
		
		person2.setFirstname("Spaghetti");
		person2.setLastname("Joe");
		person2.setAge(33);
		em.persist(person2);
		
		person3.setFirstname("Sula");
		person3.setLastname("Cronim");
		person3.setAge(37);
		em.persist(person3);
		
		em.flush();
	}
	
	@Test
	public void findByAgeGreaterThanEqualTest() {
		List<Person> results1 = personRepo.findByAgeGreaterThanEqual(30);
		assertEquals(2, results1.size());
		List<Person> results2 = personRepo.findByAgeGreaterThanEqual(50);
		assertEquals(0, results2.size());
	}
	
	@Test
	public void findPersonWhereAgeBetweenTest() {
		List<Person> results1 = personRepo.findAllBetweenAges(20, 30);
		assertEquals(1, results1.size());
		List<Person> results2 = personRepo.findAllBetweenAges(30, 40);
		assertEquals(2, results2.size());
		List<Person> results3 = personRepo.findAllBetweenAges(40, 50);
		assertEquals(0, results3.size());
	}
	
	@Test
	public void findOwnerOfAnimalTest() {
		List<Person> result = personRepo.findAllHavingThisAnimal(animal);
		assertEquals(1, result.size());
		assertEquals("Arno", result.get(0).getFirstname());
	}
	
	@Test
	public void insertRandomPersonsTest() {
		List<Person> resultsBeforeInsertion = personRepo.findAll();
		assertEquals(3, resultsBeforeInsertion.size());
		
		personRepo.createPersonEntities(100);
		List<Person> resultsAfterInsertion = personRepo.findAll();
		assertEquals(103, resultsAfterInsertion.size());
	}
	
	@Test
	public void deletePersonsWithoutAnimalTest() {
		List<Person> resultsBeforeDeletion = personRepo.findAll();
		assertEquals(3, resultsBeforeDeletion.size());
		
		personRepo.deletePersonsWithoutAnimal();
		List<Person> resultsAfterDeletion = personRepo.findAll();
		assertEquals(1, resultsAfterDeletion.size());
	}
	
}
