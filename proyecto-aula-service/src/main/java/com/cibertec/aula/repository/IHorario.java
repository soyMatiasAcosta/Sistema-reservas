package com.cibertec.aula.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.Horario;

@Repository
public interface IHorario extends JpaRepository<Horario,Integer>{

	List<Horario> findByEstadoTrue();
}
