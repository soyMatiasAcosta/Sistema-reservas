package com.cibertec.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.aula.model.CarreraTipoAula;

@Repository
public interface ICarreraTipoAula extends JpaRepository<CarreraTipoAula,Integer> {

}
