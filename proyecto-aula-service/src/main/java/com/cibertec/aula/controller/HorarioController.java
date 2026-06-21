package com.cibertec.aula.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.aula.model.Horario;
import com.cibertec.aula.service.HorarioServices;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioServices service;

    public HorarioController(HorarioServices service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listar() {
        return ResponseEntity.ok(service.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtener(@PathVariable Integer id) {
        Horario horario = service.obtenerHorarioPorId(id);
        return horario != null ? ResponseEntity.ok(horario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Horario> registrar(@RequestBody Horario horario) {
        return ResponseEntity.status(201).body(service.registrarHorario(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizar(@PathVariable Integer id, @RequestBody Horario horario) {
        return ResponseEntity.ok(service.actualizarHorario(id, horario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }
}