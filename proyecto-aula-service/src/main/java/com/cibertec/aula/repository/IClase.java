package com.cibertec.aula.repository;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.Clase;

@Repository
public interface IClase extends JpaRepository<Clase,Integer> {
    long countByIdAulaAndIdHorarioAndFecha(Integer idAula, Integer idHorario, LocalDate fecha);
}
