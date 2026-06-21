package com.cibertec.service.feign;

import lombok.Data;

@Data
public class AulaFeignDTO {
	
	private Integer idAula;
	private String codigo;
	private String nombre;
	private Integer capacidad;
	private Integer idSede;
	private Integer idTipoAula;
	
	private boolean estado;
}
