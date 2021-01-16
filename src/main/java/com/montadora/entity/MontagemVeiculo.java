package com.montadora.entity;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MontagemVeiculo {
	
	private Set<EscolhaTipoCor> escolhaTipoCor;
	private Integer codigoChasi;
	private String marcaChasi;
	private BigDecimal precoChasi;
	private String descricaoCor;
	private Integer codigoMotor;
	private String marcaMotor;
	private BigDecimal precoMotor;
	private Integer aroPneu;
	private BigDecimal precoPneu;
	
/*	public MontagemVeiculo(Chasi chasi, Cor cor, 
			Motor motor, Pneu pneu, Set<EscolhaTipoCor> escolhaTipoCor ) {
		
		this.escolhaTipoCor = escolhaTipoCor;
		this.codigoChasi = chasi.getCodigo();
		this.marcaChasi = chasi.getMarca();
		this.precoChasi = chasi.getPreco();
		this.descricaoCor = cor.getDescricao();
		this.codigoMotor = motor.getCodigo();
		this.marcaMotor = motor.getMarca();
		this.precoMotor = motor.getPreco();
		this.aroPneu = pneu.getAro();
		this.precoPneu = pneu.getPreco();
		
	} */
	
	
	
}
