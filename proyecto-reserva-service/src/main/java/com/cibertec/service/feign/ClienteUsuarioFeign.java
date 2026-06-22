package com.cibertec.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-usuarios")
public interface ClienteUsuarioFeign {

    @GetMapping("/api/usuarios/{id}")
    UsuarioFeignDTO obtenerUsuarioPorId(@PathVariable("id") Integer id);
    
}