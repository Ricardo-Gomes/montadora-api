package com.montadora.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "fk_chasi")
	private Chasi chasi;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "fk_cor")
	private Cor cor;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "fk_motor")
	private Motor motor;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "fk_pneus")
	private Pneu pneu;
}
