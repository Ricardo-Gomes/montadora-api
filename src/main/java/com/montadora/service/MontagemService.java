package com.montadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montadora.entity.Chasi;
import com.montadora.entity.Cor;
import com.montadora.entity.Motor;
import com.montadora.entity.Pneu;
import com.montadora.repository.ChasiRepository;
import com.montadora.repository.CorRepository;
import com.montadora.repository.MotorRepository;
import com.montadora.repository.PneuRepository;

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
	public void calcularMontagem(Chasi chasi, Cor cor, Motor motor, Pneu pneu) {

		pneuService.CalculoPneu(pneu.getPreco());
		corService.EscolhaTipoCor(cor.getTipo());
		
		Double valorChasi = chasi.getPreco(), valorCor = cor.getTipo(), valorMotor = motor.getPreco(),
				valorPneu = pneu.getPreco();

		Double valorMontagem = (valorChasi + valorCor + valorMotor + valorPneu) / 10;

	}
	
	@Transactional
	public void verificacaoMontagem (Chasi chasi, Cor cor, Motor motor, Pneu pneu) {
		calcularMontagem(chasi, cor, motor, pneu);
		motorChasiService.validarMarcaChasiMotor(chasi, motor);
	}
}
