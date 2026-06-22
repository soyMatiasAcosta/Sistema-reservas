package com.cibertec.auth.dto.response;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoInstitucional;
    private String codigoInstitucional;
    private String contrasena;   // para validar
    private String rolNombre;
    private Long idSede;
    private Long idCarrera;
    private Integer idAdminSedeCheck;
}