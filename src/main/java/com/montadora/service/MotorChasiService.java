package com.montadora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montadora.entity.Chasi;
import com.montadora.entity.Motor;
import com.montadora.repository.ChasiRepository;
import com.montadora.repository.MotorRepository;

@Service
public class MotorChasiService {
	
	@Autowired
	private MotorRepository motorRepository;

	@Autowired
	private ChasiRepository chasiRepository;
	
	public void validarMarcaChasiMotor(Chasi chasi, Motor motor) {
		
		List<String> checagem = new ArrayList<String>();
		
		if (chasi.getMarca() != motor.getMarca()) {
			checagem.add("O Motor e Chasi precisam ser do mesmo Fabricante.");
		}
	}
}
