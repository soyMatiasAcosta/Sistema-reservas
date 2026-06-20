package com.cibertec.notificacion.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reporte_semanal")
@Data
public class ReporteSemanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;

    @Column(nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(nullable = false)
    private LocalDate fechaInicioSemana;

    @Column(nullable = false)
    private LocalDate fechaFinSemana;

    @Column(nullable = false)
    private Integer totalReservas;

    @Column(nullable = false)
    private Integer idAdmin;
}