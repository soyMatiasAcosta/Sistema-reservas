package com.cibertec.service.controller;

import com.cibertec.service.dto.TipoReservaDTO;
import com.cibertec.service.services.TipoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-reserva")
public class TipoReservaController {

    @Autowired
    private TipoReservaService servicio;

    
    @GetMapping
    public ResponseEntity<List<TipoReservaDTO>> listar() {
        List<TipoReservaDTO> lista = servicio.listarTipos();
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