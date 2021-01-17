package com.montadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montadora.entity.Cor;
import com.montadora.repository.CorRepository;

@Service
public class CorService {
	
	@Autowired
	private CorRepository repository;
	
	private Cor cor;
	
	public void EscolhaTipoCor(Double tipo) {
		
		if (cor.getTipo() == 1) {
			Double perola = cor.getTipo() + 5000;
		}
		
		if (cor.getTipo() == 2 ) {
			Double perola = cor.getTipo() + 1000;
		}
	}

}
