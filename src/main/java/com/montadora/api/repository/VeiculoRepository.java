package com.montadora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montadora.api.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
