package com.montadora.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montadora.api.entity.Pneu;
import com.montadora.api.repository.PneuRepository;

@Service
public class PneuService {

	@Autowired
	private PneuRepository repository;

	public Double calculoPreco5Pneus(Pneu pneu) {
		Double valorPneus = pneu.getPreco() * 5;
		return valorPneus;
	}
}
