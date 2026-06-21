package com.cibertec.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.TipoAula;

@Repository
public interface ITipoAula extends JpaRepository<TipoAula,Integer> {
	List<TipoAula> findByEstadoTrue();

}
