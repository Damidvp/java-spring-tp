package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Integer>{

}
