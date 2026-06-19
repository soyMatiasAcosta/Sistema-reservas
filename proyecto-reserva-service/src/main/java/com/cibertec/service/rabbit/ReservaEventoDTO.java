package com.cibertec.service.rabbit;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservaEventoDTO {
    private Integer idReserva;
    
    private LocalDate fechaReserva;
    private LocalDateTime fechaSolicitud;
    private Integer idUsuario;
    private Integer idAula;
    private Integer idSede;
    private Integer idHorario;
    private Integer idEstadoReserva;
    private Integer idTipoReserva;
    private String tipoEvento;
    
}