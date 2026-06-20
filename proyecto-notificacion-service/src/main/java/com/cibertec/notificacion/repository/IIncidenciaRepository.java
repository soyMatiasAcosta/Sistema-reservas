package com.cibertec.notificacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.notificacion.model.Incidencia;

@Repository
public interface IIncidenciaRepository extends JpaRepository<Incidencia, Integer>{
	List<Incidencia> findByIdUsuario(Integer idUsuario);
}
