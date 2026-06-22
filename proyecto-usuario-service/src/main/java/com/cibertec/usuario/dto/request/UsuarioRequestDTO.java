package com.cibertec.usuario.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombreUsuario;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100)
    private String apellidoUsuario;

    @NotBlank(message = "El correo institucional es obligatorio")
    @Email(message = "El correo debe ser válido")
    @Size(max = 60)
    private String correoInstitucional;

    @NotBlank(message = "El código institucional es obligatorio")
    @Size(max = 20)
    private String codigoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @NotNull(message = "El rol es obligatorio")
    private Long idRol;

    @NotNull(message = "La sede es obligatoria")
    private Long idSede;

    @NotNull(message = "La carrera es obligatoria")
    private Long idCarrera;

    private Integer idAdminSedeCheck; // opcional
}