package com.cibertec.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_tipo_reserva")
@Data
public class TipoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoReserva;

    @Column(length = 50, nullable = false)
    private String descripcion;
}