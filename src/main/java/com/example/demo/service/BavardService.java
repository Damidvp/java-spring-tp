package com.example.demo.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BavardService {
	
	private String nom = "Arno Camoa";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void parler() {
		System.out.println(this.nom + " [" + this.getClass().getSimpleName() + "]");
	}
	
	@PostConstruct
	private void postConstruct() {
		System.out.println("Print de postConstruct");
	}
	
}
