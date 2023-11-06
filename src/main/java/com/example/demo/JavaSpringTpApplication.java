package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enums.Sex;
import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.model.Species;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.SpeciesRepository;
import com.example.demo.service.BavardService;

import jakarta.persistence.Cache;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.PersistenceUnitUtil;
import jakarta.persistence.Query;
import jakarta.persistence.SynchronizationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.transaction.Transactional;

@SpringBootApplication
@RestController
public class JavaSpringTpApplication implements CommandLineRunner {
	
	@Autowired
	private BavardService bavardService;
	
	@Autowired
	private AnimalRepository animalRepo;
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private SpeciesRepository speciesRepo;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringTpApplication.class, args);
	}
	
	@GetMapping("hello")
	public String hello() {
		//bavardService.parler();
		return "Hello World!";
	}
	
	@GetMapping("blabla")
	public String blabla() {
		return bavardService.parler();
	}

	@Override @Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(Animal animal : animalRepo.findAll()) {
			System.out.println(animal.toString());
		}
		
		for(Person person : personRepo.findAll()) {
			System.out.println(person.toString());
		}
		
		for(Species species : speciesRepo.findAll()) {
			System.out.println(species.toString());
		}
		
		Animal animal1 = new Animal("Black", "Viéra", Sex.M, speciesRepo.findById(3).orElseThrow());
		//animalRepo.save(animal1);
		
		Person person1 = new Person(21, "Arno", "Camoa");
		//personRepo.save(person1);
		
		Species species1 = new Species("Bec-en-sabot", "Balaeniceps rex");
		//speciesRepo.save(species1);
		
		person1.addAnimal(animal1);
		//animalRepo.save(animal1);
		//personRepo.save(person1);
		
		System.out.println(personRepo.findById(5).toString());
		
		//personRepo.delete(personRepo.findById(6).orElseThrow());
		
		System.out.println("NB ELEMENTS LISTES :\n" + "Animal: " + animalRepo.count() + " | Person: " + 
				personRepo.count() + " | Species: " + speciesRepo.count());
	}

}
