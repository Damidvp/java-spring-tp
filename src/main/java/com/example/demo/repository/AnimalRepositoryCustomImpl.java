package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.enums.Sex;
import com.example.demo.model.Animal;
import com.example.demo.model.Species;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AnimalRepositoryCustomImpl implements AnimalRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	private List<String> randomColors = new ArrayList<>();
	private List<String> randomNames = new ArrayList<>();
	private List<Sex> randomSexs = new ArrayList<>();
	private List<Species> randomSpecies = new ArrayList<>();
	
	@Override
	public void createAnimalEntites(Integer numberOfEntities) {
		// TODO Auto-generated method stub
		createLists();
		for(int i=0; i<numberOfEntities; i++) {
			Animal animal = new Animal();
			
			animal.setColor(randomColors.get(new Random().nextInt(randomColors.size())));
			animal.setName(randomNames.get(new Random().nextInt(randomNames.size())));
			animal.setSex(randomSexs.get(new Random().nextInt(randomSexs.size())));
			animal.setSpecies(randomSpecies.get(new Random().nextInt(randomSpecies.size())));
			
			em.persist(animal);
		}
	}
	
	private void createLists() {
		randomColors.add("Noir");
		randomColors.add("Blanc");
		randomColors.add("Roux");
		randomColors.add("Gris");
		randomColors.add("Violet");
		
		randomNames.add("Alphinaud");
		randomNames.add("Alisaie");
		randomNames.add("Estinien");
		randomNames.add("G'raha Tia");
		randomNames.add("Y'shtola");
		randomNames.add("Thancred");
		
		randomSexs.add(Sex.M);
		randomSexs.add(Sex.F);
		
		List<Species> allSpecies = em.createQuery("SELECT s FROM Species s").getResultList();
		for(Species species : allSpecies) {
			randomSpecies.add(species);
		}
	}

}
