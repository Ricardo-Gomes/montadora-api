package com.montadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montadora.entity.Pneu;
import com.montadora.repository.PneuRepository;

@Service
public class PneuService {

	@Autowired
	private PneuRepository repository;
	
	private Pneu pneu;
	
	public Double CalculoPneu(Double preco) {
		
		Double valorPneus = pneu.getPreco() * 5;
		
		return valorPneus;
	}
}
