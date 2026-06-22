package com.cibertec.service.repository;

import com.cibertec.service.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    // alumno ve sus reservas
    List<Reserva> findByIdUsuario(Integer idUsuario);

    // filtro del admin para reservas pendientes
    List<Reserva> findByIdEstadoReserva(Integer idEstadoReserva);

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.idAula = :idAula AND r.fechaReserva = :fechaReserva AND r.idHorario = :idHorario AND r.idEstadoReserva IN (1, 2)")
    long contarReservasActivas(@Param("idAula") Integer idAula, @Param("fechaReserva") LocalDate fechaReserva, @Param("idHorario") Integer idHorario);
    
    long countByIdUsuarioAndFechaReservaAndIdEstadoReservaIn(Integer idUsuario, LocalDate fechaReserva, List<Integer> estados);
}