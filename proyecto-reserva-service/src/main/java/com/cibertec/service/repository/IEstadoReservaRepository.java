package com.cibertec.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.service.model.EstadoReserva;

@Repository
public interface IEstadoReservaRepository extends JpaRepository<EstadoReserva, Integer>{

}
