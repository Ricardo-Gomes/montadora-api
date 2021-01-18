package com.montadora.api.service;

import org.springframework.stereotype.Service;

import com.montadora.api.entity.Cor;

@Service
public class CorService {

	public Double obterPrecoDaCor(Cor cor) {
		Integer tipo = cor.getTipo();
		if (tipo.equals(1)) {
			return 5000d;
		}
		return 1000d;
	}

}
