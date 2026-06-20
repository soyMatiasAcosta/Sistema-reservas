package com.cibertec.service.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservaRequestDTO {
	
    private LocalDate fechaReserva;
    private Integer idUsuario;
    private Integer idAula;
    private Integer idSede;
    private Integer idHorario;
    private Integer idTipoReserva;
    
}