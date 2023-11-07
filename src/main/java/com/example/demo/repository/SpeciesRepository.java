package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Integer>{

	Species findFirstByCommonName(String commonName);
	List<Species> findByLatinNameContainsIgnoreCase(String latinName);
	
}
