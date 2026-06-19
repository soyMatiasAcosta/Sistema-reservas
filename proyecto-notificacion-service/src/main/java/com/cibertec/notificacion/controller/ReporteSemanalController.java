package com.cibertec.notificacion.controller;

import com.cibertec.notificacion.dto.ReporteSemanalDTO;
import com.cibertec.notificacion.services.ReporteSemanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteSemanalController {

    @Autowired
    private ReporteSemanalService servicio;

    @GetMapping
    public ResponseEntity<List<ReporteSemanalDTO>> listarTodos() {
        List<ReporteSemanalDTO> lista = servicio.listarTodos();
        
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
    
    
}