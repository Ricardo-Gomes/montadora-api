package com.montadora.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "montadora", name = "pneus")
public class Pneus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotNull(message = "O campo aro é obrigatorio")
	@Column(nullable = false, length = 50)
	private Integer aro;

	@NotNull(message = "O campo Preço é obrigatorio.")
	@Column(nullable = false)
	private BigDecimal preco;
}
