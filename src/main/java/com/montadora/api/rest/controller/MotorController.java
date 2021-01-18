package com.montadora.api.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montadora.api.entity.Motor;
import com.montadora.api.repository.MotorRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/motor")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class MotorController {

	private final MotorRepository repository;

	@GetMapping
	public List<Motor> obterTodos() {
		return repository.findAll();
	}

}
