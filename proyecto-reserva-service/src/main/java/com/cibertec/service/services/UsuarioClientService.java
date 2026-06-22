package com.cibertec.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.service.feign.ClienteUsuarioFeign;
import com.cibertec.service.feign.UsuarioFeignDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UsuarioClientService {

    @Autowired
    private ClienteUsuarioFeign clienteUsuario;

    @CircuitBreaker(name = "servicio-usuarios", fallbackMethod = "fallbackObtenerUsuario")
    public UsuarioFeignDTO obtenerUsuarioSeguro(Integer idUsuario) {
        return clienteUsuario.obtenerUsuarioPorId(idUsuario);
    }

    public UsuarioFeignDTO fallbackObtenerUsuario(Integer idUsuario, Throwable t) {
        System.out.println("Fallback ejecutado por error de conexión con Usuarios: " + t.getMessage());
        return new UsuarioFeignDTO();
    }
}