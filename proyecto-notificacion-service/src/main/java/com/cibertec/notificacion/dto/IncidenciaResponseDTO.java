package com.cibertec.notificacion.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IncidenciaResponseDTO {
	
    private Integer idIncidencia;
    private String asunto;
    private String descripcion;
    private LocalDateTime fechaGeneracion;
    private Integer idUsuario;
    private Integer idAula;
    
}