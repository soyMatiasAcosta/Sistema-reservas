package com.cibertec.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_estado_reserva")
@Data
public class EstadoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoReserva;

    @Column(length = 30, nullable = false)
    private String descripcion;
}