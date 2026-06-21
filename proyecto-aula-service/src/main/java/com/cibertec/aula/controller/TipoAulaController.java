package com.cibertec.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.aula.model.TipoAula;
import com.cibertec.aula.service.TipoAulaServices;

@RestController
@RequestMapping("/api/tipos-aula")
public class TipoAulaController {

	@Autowired
	private TipoAulaServices service;

	@GetMapping
	public ResponseEntity<List<TipoAula>> listar() {
		return ResponseEntity.ok(service.listarTiposAula());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoAula> obtener(@PathVariable Integer id) {
		TipoAula tipo = service.obtenerTipoAulaPorId(id);
		return tipo != null ? ResponseEntity.ok(tipo) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<TipoAula> registrar(@RequestBody TipoAula tipoAula) {
		return ResponseEntity.status(201).body(service.registrarTipoAula(tipoAula));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoAula> actualizar(@PathVariable Integer id, @RequestBody TipoAula tipoAula) {
		return ResponseEntity.ok(service.actualizarTipoAula(id, tipoAula));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		service.eliminarTipoAula(id);
		return ResponseEntity.noContent().build();
	}
}