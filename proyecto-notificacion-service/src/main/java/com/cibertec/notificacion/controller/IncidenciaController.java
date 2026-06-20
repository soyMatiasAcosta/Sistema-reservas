package com.cibertec.notificacion.controller;

import com.cibertec.notificacion.dto.IncidenciaResponseDTO;
import com.cibertec.notificacion.services.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService servicio;

    @GetMapping
    public ResponseEntity<List<IncidenciaResponseDTO>> listarTodas() {
        List<IncidenciaResponseDTO> lista = servicio.listarTodas();
        if (lista.isEmpty()) 
        	return ResponseEntity.noContent().build();
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
    public ResponseEntity<List<IncidenciaResponseDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
    	
        List<IncidenciaResponseDTO> lista = servicio.listarPorUsuario(idUsuario);
        
        if (lista.isEmpty()) 
        	return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
        
    }
    
    
}