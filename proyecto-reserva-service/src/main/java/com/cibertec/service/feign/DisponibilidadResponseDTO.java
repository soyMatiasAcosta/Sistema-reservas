package com.cibertec.service.feign;

import lombok.Data;

@Data
public class DisponibilidadResponseDTO {
    private Integer idAula;
    private Integer idHorario;
    private String fecha;
    private boolean disponible;
    private String mensaje;
}