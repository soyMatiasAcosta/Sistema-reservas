package com.cibertec.service.controller;

import com.cibertec.service.dto.ReservaRequestDTO;
import com.cibertec.service.dto.ReservaResponseDTO;
import com.cibertec.service.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService servicio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ReservaRequestDTO dto) {
        try {
            ReservaResponseDTO nueva = servicio.crearReserva(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listarTodas() {
        List<ReservaResponseDTO> lista = servicio.listarTodas();
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
    
    

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaResponseDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
        List<ReservaResponseDTO> lista = servicio.listarPorUsuario(idUsuario);
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    
    
    @GetMapping("/pendientes")
    public ResponseEntity<List<ReservaResponseDTO>> listarPendientes() {
        List<ReservaResponseDTO> lista = servicio.listarPendientes();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    
    @PutMapping("/{id}/aprobar")
    public ResponseEntity<?> aprobar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.aprobarReserva(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    

    @PutMapping("/{id}/rechazar")
    public ResponseEntity<?> rechazar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.rechazarReserva(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    
}