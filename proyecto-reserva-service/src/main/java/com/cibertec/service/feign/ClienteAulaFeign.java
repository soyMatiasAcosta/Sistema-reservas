package com.cibertec.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "aula-service")
public interface ClienteAulaFeign {

    @GetMapping("/api/aulas/{id}")
    AulaFeignDTO obtenerAulaPorId(@PathVariable("id") Integer id);

    @GetMapping("/api/aulas/disponibilidad")
    DisponibilidadResponseDTO verificarDisponibilidad(
            @RequestParam("idAula") Integer idAula,
            @RequestParam("idHorario") Integer idHorario,
            @RequestParam("fecha") String fecha
    );
}