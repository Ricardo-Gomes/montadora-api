package com.montadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.montadora.entity.Chasi;

public interface ChasiRepository extends JpaRepository<Chasi, Long>{

	//@Query("select c from Chasi c where c.codigo = :codigo")
	//List<Chasi> findByChasi (@Param ("codigo") Integer codigo );
}
