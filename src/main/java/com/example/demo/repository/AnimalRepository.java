package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Animal;
import com.example.demo.model.Species;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	List<Animal> findBySpecies(Species species);
	List<Animal> findAllByColorIn(List<String> colors);
}
