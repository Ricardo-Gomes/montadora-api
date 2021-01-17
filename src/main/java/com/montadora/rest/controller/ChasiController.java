package com.montadora.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montadora.entity.Chasi;
import com.montadora.repository.ChasiRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chasi")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ChasiController {

	@Autowired
	private ChasiRepository repository;
	
	@GetMapping
	public List<Chasi> obterTodos(){
		return repository.findAll();
	}
	
}
