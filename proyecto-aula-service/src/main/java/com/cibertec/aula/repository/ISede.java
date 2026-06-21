package com.cibertec.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.Sede;

@Repository
public interface ISede extends JpaRepository<Sede,Integer> {

	List<Sede> findByEstadoTrue();
}
