package com.cibertec.aula.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.aula.dto.DisponibilidadResponse;
import com.cibertec.aula.model.Aula;
import com.cibertec.aula.service.AulaServices;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    private final AulaServices service;

    public AulaController(AulaServices service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Aula>> listar() {
        return ResponseEntity.ok(service.listarAulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> obtener(@PathVariable Integer id) {
        Aula aula = service.obtenerAulaPorId(id);
        return aula != null ? ResponseEntity.ok(aula) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Aula> registrar(@RequestBody Aula aula) {
        return ResponseEntity.status(201).body(service.registrarAula(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> actualizar(@PathVariable Integer id, @RequestBody Aula aula) {
        return ResponseEntity.ok(service.actualizarAula(id, aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarAula(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<DisponibilidadResponse> verificarDisponibilidad(
            @RequestParam Integer idAula,
            @RequestParam Integer idHorario,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        
        return ResponseEntity.ok(service.verificarDisponibilidad(idAula, idHorario, fecha));
    }
}