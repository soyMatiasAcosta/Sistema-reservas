package com.cibertec.service.controller;

import com.cibertec.service.dto.EstadoReservaDTO;
import com.cibertec.service.services.EstadoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-reserva")
public class EstadoReservaController {

    @Autowired
    private EstadoReservaService servicio;

    @GetMapping
    public ResponseEntity<List<EstadoReservaDTO>> listar() {
        List<EstadoReservaDTO> lista = servicio.listarEstados();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.obtenerPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}