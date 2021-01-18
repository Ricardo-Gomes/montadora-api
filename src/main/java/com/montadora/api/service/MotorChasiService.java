package com.montadora.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montadora.api.entity.Chasi;
import com.montadora.api.entity.Motor;
import com.montadora.api.repository.ChasiRepository;
import com.montadora.api.repository.MotorRepository;

@Service
public class MotorChasiService {

	@Autowired
	private MotorRepository motorRepository;

	@Autowired
	private ChasiRepository chasiRepository;

	public List<String> validarMarcaChasiMotor(Chasi chasi, Motor motor) {

		List<String> checagem = new ArrayList<String>();

		if (chasi.getCodigo() != motor.getCodigo()) {
			checagem.add("O Motor e Chasi precisam ser do mesmo Fabricante.");
		}

		return checagem;
	}
}
