package com.montadora.api.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montadora.api.entity.Chasi;
import com.montadora.api.entity.Cor;
import com.montadora.api.entity.Motor;
import com.montadora.api.entity.Pneu;
import com.montadora.api.repository.ChasiRepository;
import com.montadora.api.repository.CorRepository;
import com.montadora.api.repository.MotorRepository;
import com.montadora.api.repository.PneuRepository;
import com.montadora.api.repository.VeiculoRepository;
import com.montadora.api.rest.dto.MontagemVeiculoDTO;
import com.montadora.api.service.MontagemService;

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
	public ResponseEntity realizarMontagem(@RequestBody @Valid MontagemVeiculoDTO dto) {

		Long idChasi = dto.getIdChasi();

		Optional<Chasi> chasi = chasiRepository.findById(idChasi);
		if (!chasi.isPresent()) {
			return ResponseEntity.badRequest().body("Chasi Inexistente");
		}

		Long idCor = dto.getIdCor();

		Optional<Cor> cor = corRepository.findById(idCor);
		if (!cor.isPresent()) {
			return ResponseEntity.badRequest().body("Cor Inexistente");
		}

		Long idMotor = dto.getIdMotor();

		Optional<Motor> motor = motorRepository.findById(idMotor);
		if (!motor.isPresent()) {
			return ResponseEntity.badRequest().body("Motor Inexistente");
		}

		Long idPneus = dto.getIdPneu();

		Optional<Pneu> pneu = pneuRepository.findById(idPneus);
		if (!pneu.isPresent()) {
			return ResponseEntity.badRequest().body("Pneu Inexistente");
		}

		List<String> erros = montagemService.verificacaoMontagem(chasi.get(), cor.get(), motor.get(), pneu.get());
		if (!erros.isEmpty()) {
			return ResponseEntity.badRequest().body(erros);
		}

		Double resultado = montagemService.calcularMontagem(chasi.get(), cor.get(), motor.get(), pneu.get());
		return ResponseEntity.ok(resultado);
	}
}
