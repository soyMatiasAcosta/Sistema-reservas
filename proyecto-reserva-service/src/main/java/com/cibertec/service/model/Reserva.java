package com.cibertec.service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reserva")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false)
    private Integer idAula;

    @Column(nullable = false)
    private Integer idSede;

    @Column(nullable = false)
    private Integer idHorario;

    @Column(nullable = false)
    private Integer idEstadoReserva;

    @Column(nullable = false)
    private Integer idTipoReserva;
}