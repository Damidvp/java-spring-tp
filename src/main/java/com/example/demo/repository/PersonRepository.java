package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	List<Person> findByFirstnameOrLastname(String firstname, String lastname);
	List<Person> findByAgeGreaterThanEqual(Integer age);
}
