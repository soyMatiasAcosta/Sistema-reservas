package com.cibertec.auth.feign;

import com.cibertec.auth.dto.request.RegisterRequestDTO;
import com.cibertec.auth.dto.response.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/email/{email}")
    UsuarioDTO obtenerUsuarioPorEmail(@PathVariable("email") String email);


    @PostMapping("/api/usuarios")
    UsuarioDTO crearUsuario(@RequestBody RegisterRequestDTO request);
}
