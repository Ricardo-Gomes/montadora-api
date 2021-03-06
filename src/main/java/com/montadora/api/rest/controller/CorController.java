package com.montadora.api.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montadora.api.entity.Cor;
import com.montadora.api.repository.CorRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cor")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CorController {

	private final CorRepository repository;

	@GetMapping
	public List<Cor> obterTodos() {
		return repository.findAll();
	}

}
