package com.cibertec.service.repository;

import com.cibertec.service.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    // alumno ve sus reservas
    List<Reserva> findByIdUsuario(Integer idUsuario);

    // filtro del admin para reservas pendientes
    List<Reserva> findByIdEstadoReserva(Integer idEstadoReserva);

}