package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
