package com.cibertec.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.service.feign.AulaFeignDTO;
import com.cibertec.service.feign.ClienteAulaFeign;
import com.cibertec.service.feign.DisponibilidadResponseDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AulaClientService {

    @Autowired
    private ClienteAulaFeign clienteAula;

    
    
    @CircuitBreaker(name = "aula-service", fallbackMethod = "fallbackObtenerAula")
    public AulaFeignDTO obtenerAulaSegura(Integer idAula) {
        return clienteAula.obtenerAulaPorId(idAula);
    }
    
    
    

    public AulaFeignDTO fallbackObtenerAula(Integer idAula, Throwable t) {
        System.out.println("Fallback ejecutado por error de conexión con Aulas: " + t.getMessage());
        return new AulaFeignDTO();
    }
    
    
    

    @CircuitBreaker(name = "aula-service", fallbackMethod = "fallbackVerificarDisponibilidad")
    public DisponibilidadResponseDTO verificarDisponibilidadSegura(Integer idAula, Integer idHorario, String fecha) {
        return clienteAula.verificarDisponibilidad(idAula, idHorario, fecha);
    }
    
    

    public DisponibilidadResponseDTO fallbackVerificarDisponibilidad(Integer idAula, Integer idHorario, String fecha, Throwable t) {
        System.out.println("Fallback disponibilidad ejecutado: " + t.getMessage());
        
        DisponibilidadResponseDTO fallback = new DisponibilidadResponseDTO();
        fallback.setDisponible(false);
        fallback.setMensaje("ERROR_CONEXION");
        return fallback;
    }
    
    
    
    
    
}