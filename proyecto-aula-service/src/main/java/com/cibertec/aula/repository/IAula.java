package com.cibertec.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.Aula;

@Repository
public interface IAula extends JpaRepository<Aula, Integer> {

	List<Aula> findByEstadoTrue();

	@Modifying
	@Query("UPDATE Aula a SET a.estado = false WHERE a.idAula = :id")
	void eliminarLogico(@Param("id") Integer id);

}
