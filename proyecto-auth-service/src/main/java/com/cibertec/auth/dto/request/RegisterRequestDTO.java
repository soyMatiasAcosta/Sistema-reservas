package com.cibertec.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombreUsuario;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100)
    private String apellidoUsuario;

    @NotBlank(message = "El correo es obligatorio")
    @Email
    @Size(max = 60)
    private String correoInstitucional;

    @Size(max = 20)
    private String codigoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @NotNull(message = "El rol es obligatorio")
    private Long idRol;

    private Long idSede;
    private Long idCarrera;
    private Integer idAdminSedeCheck;
}