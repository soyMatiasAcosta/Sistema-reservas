package com.cibertec.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.aula.model.Sede;
import com.cibertec.aula.service.SedeServices;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

	@Autowired
	private SedeServices service;

	@GetMapping
	public ResponseEntity<List<Sede>> listar() {
		return ResponseEntity.ok(service.listarSedes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sede> obtener(@PathVariable Integer id) {
		Sede sede = service.obtenerSedePorId(id);
		return sede != null ? ResponseEntity.ok(sede) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Sede> registrar(@RequestBody Sede sede) {
		return ResponseEntity.status(201).body(service.registrarSede(sede));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Sede> actualizar(@PathVariable Integer id, @RequestBody Sede sede) {
		return ResponseEntity.ok(service.actualizarSede(id, sede));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		service.eliminarSede(id);
		return ResponseEntity.noContent().build();
	}
}