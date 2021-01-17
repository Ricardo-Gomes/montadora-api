package com.montadora.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "montadora", name = "chasi")
public class Chasi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotNull(message = "O campo Código é obrigatorio.")
	@Column(nullable = false)
	private Integer codigo;

	@NotEmpty(message = "O campo marca é obrigatorio")
	@Column(nullable = false, length = 50)
	private String marca;

	@NotNull(message = "O campo Preço é obrigatorio.")
	@Column(nullable = false)
	private Double preco;
	
}
