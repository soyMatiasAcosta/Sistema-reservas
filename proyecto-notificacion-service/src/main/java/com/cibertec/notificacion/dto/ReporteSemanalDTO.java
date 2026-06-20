package com.cibertec.notificacion.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReporteSemanalDTO {
	
    private Integer idReporte;
    
    private LocalDateTime fechaGeneracion;
    private LocalDate fechaInicioSemana;
    private LocalDate fechaFinSemana;
    
    private Integer totalReservas;
    private Integer idAdmin;
    
}