package com.cibertec.aula.dto;

import lombok.Data;

@Data
public class DisponibilidadResponse {

	private Integer idAula;
    private Integer idHorario;
    private String fecha;
    private Boolean disponible;
    private String mensaje;
}
