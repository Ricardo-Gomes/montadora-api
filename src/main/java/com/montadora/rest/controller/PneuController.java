package com.montadora.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montadora.entity.Pneu;
import com.montadora.repository.PneuRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pneu")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PneuController {

	private final PneuRepository repository;
	
	@GetMapping
	public List<Pneu> obterTodos(){
		return repository.findAll();
	}
	
}
