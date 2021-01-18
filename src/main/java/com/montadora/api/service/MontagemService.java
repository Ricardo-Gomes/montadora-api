package com.montadora.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montadora.api.entity.Chasi;
import com.montadora.api.entity.Cor;
import com.montadora.api.entity.Motor;
import com.montadora.api.entity.Pneu;
import com.montadora.api.repository.ChasiRepository;
import com.montadora.api.repository.CorRepository;
import com.montadora.api.repository.MotorRepository;
import com.montadora.api.repository.PneuRepository;

@Service
public class MontagemService {

	@Autowired
	private ChasiRepository chasiRepository;

	@Autowired
	private CorRepository corRepository;

	@Autowired
	private MotorRepository motorRepository;

	@Autowired
	private PneuRepository pneuRepository;

	@Autowired
	private MotorChasiService motorChasiService;

	@Autowired
	private CorService corService;

	@Autowired
	private PneuService pneuService;

	@Transactional
	public Double calcularMontagem(Chasi chasi, Cor cor, Motor motor, Pneu pneu) {
		Double precoMotor = motor.getPreco();
		Double precoDaCor = corService.obterPrecoDaCor(cor);
		Double precoChasi = chasi.getPreco();
		Double precoPneus = pneuService.calculoPreco5Pneus(pneu);

		Double precoTotalDasPecas = precoMotor + precoDaCor + precoChasi + precoPneus;
		Double precoMontagem = precoTotalDasPecas + (precoTotalDasPecas * 10);

		return precoMontagem;
	}

	@Transactional
	public List<String> verificacaoMontagem(Chasi chasi, Cor cor, Motor motor, Pneu pneu) {
		return motorChasiService.validarMarcaChasiMotor(chasi, motor);
	}
}
