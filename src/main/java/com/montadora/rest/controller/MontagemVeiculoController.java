package com.montadora.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.montadora.entity.Chasi;
import com.montadora.entity.Cor;
import com.montadora.entity.Motor;
import com.montadora.entity.Pneu;
import com.montadora.entity.Veiculo;
import com.montadora.repository.ChasiRepository;
import com.montadora.repository.CorRepository;
import com.montadora.repository.VeiculoRepository;
import com.montadora.repository.MotorRepository;
import com.montadora.repository.PneuRepository;
import com.montadora.rest.dto.MontagemVeiculoDTO;
import com.montadora.service.MontagemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/montagem")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class MontagemVeiculoController {

	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private ChasiRepository chasiRepository;
	
	@Autowired
	private CorRepository corRepository;
	
	@Autowired
	private MotorRepository motorRepository;
	
	@Autowired
	private PneuRepository pneuRepository;
	
	@Autowired
	private MontagemService montagemService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo realizarMontagem(@RequestBody @Valid MontagemVeiculoDTO dto) {

		Long idChasi = dto.getIdChasi();

		Chasi chasi = chasiRepository.findById(idChasi)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Chasi Inexistente"));

		Long idCor = dto.getIdCor();

		Cor cor = corRepository.findById(idCor)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cor Inexistente"));

		Long idMotor = dto.getIdMotor();

		Motor motor = motorRepository.findById(idMotor)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Motor Inexistente"));

		Long idPneus = dto.getIdPneu();

		Pneu pneu = pneuRepository.findById(idPneus)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pneu Inexistente"));

		Veiculo veiculo = new Veiculo();

		veiculo.setChasi(chasi);
		veiculo.setCor(cor);
		veiculo.setMotor(motor);
		veiculo.setPneu(pneu);
		
		montagemService.verificacaoMontagem(chasi, cor, motor, pneu);
		montagemService.calcularMontagem(chasi, cor, motor, pneu);

		return repository.save(veiculo);

	}
}
