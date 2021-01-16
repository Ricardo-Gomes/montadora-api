package com.montadora.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MontagemVeiculoDTO {

	private Long idChasi;
	private Long idCor;
	private Long idMotor;
	private Long idPneu;
}
