package com.montadora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montadora.api.entity.Motor;

public interface MotorRepository extends JpaRepository<Motor, Long> {

}
