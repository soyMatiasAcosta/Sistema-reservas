package com.cibertec.service.feign;

import lombok.Data;

@Data
public class UsuarioFeignDTO {
	
    private Long idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoInstitucional;
    private String codigoInstitucional;
    private String nombreRol;
    private String nombreSede;
    private String nombreCarrera; 
    private Integer idAdminSedeCheck;
    
}