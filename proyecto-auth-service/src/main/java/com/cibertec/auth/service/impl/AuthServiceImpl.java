package com.cibertec.auth.service.impl;

import com.cibertec.auth.dto.request.LoginRequestDTO;
import com.cibertec.auth.dto.request.RegisterRequestDTO;
import com.cibertec.auth.dto.response.AuthResponseDTO;
import com.cibertec.auth.dto.response.UsuarioDTO;
import com.cibertec.auth.feign.UsuarioClient;
import com.cibertec.auth.security.JwtService;
import com.cibertec.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioClient usuarioClient;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequest) {
        // Obtener usuario de servicio-usuarios
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorEmail(loginRequest.getEmail());

        // Validar contraseña
        if (!passwordEncoder.matches(loginRequest.getPassword(), usuario.getContrasena())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Generar token
        String token = jwtService.generateToken(usuario.getCorreoInstitucional(), usuario.getRolNombre());

        return new AuthResponseDTO(token, usuario.getCorreoInstitucional(), usuario.getNombreUsuario(), usuario.getRolNombre());
    }

    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequest) {
        // 1. Construir el DTO para el servicio de usuarios (el mismo que usas)
        RegisterRequestDTO usuarioRequest = new RegisterRequestDTO();
        usuarioRequest.setNombreUsuario(registerRequest.getNombreUsuario());
        usuarioRequest.setApellidoUsuario(registerRequest.getApellidoUsuario());
        usuarioRequest.setCorreoInstitucional(registerRequest.getCorreoInstitucional());
        usuarioRequest.setCodigoInstitucional(registerRequest.getCodigoInstitucional());

        // **** CAMBIO CLAVE: Encriptar la contraseña aquí ****
        usuarioRequest.setContrasena(passwordEncoder.encode(registerRequest.getContrasena()));

        usuarioRequest.setIdRol(registerRequest.getIdRol());
        usuarioRequest.setIdSede(registerRequest.getIdSede());
        usuarioRequest.setIdCarrera(registerRequest.getIdCarrera());
        usuarioRequest.setIdAdminSedeCheck(registerRequest.getIdAdminSedeCheck() != null ?
                registerRequest.getIdAdminSedeCheck() : 1);

        // 2. Llamar al servicio de usuarios para crear el usuario (ya recibe la contraseña encriptada)
        UsuarioDTO usuarioCreado;
        try {
            usuarioCreado = usuarioClient.crearUsuario(usuarioRequest);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear usuario: " + e.getMessage());
        }

        // 3. Generar token JWT usando el correo y rol del usuario creado
        String token = jwtService.generateToken(
                usuarioCreado.getCorreoInstitucional(),
                usuarioCreado.getRolNombre()
        );

        // 4. Devolver respuesta
        return new AuthResponseDTO(
                token,
                usuarioCreado.getCorreoInstitucional(),
                usuarioCreado.getNombreUsuario(),
                usuarioCreado.getRolNombre()
        );
    }
}