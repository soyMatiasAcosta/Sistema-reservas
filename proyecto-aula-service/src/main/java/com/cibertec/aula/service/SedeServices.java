package com.cibertec.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.aula.model.Sede;
import com.cibertec.aula.repository.ISede;

@Service
public class SedeServices {

	@Autowired
	private ISede repositorio;

	public List<Sede> listarSedes() {
		return repositorio.findByEstadoTrue();
	}

	public Sede obtenerSedePorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public Sede registrarSede(Sede sede) {
		sede.setEstado(true);
		return repositorio.save(sede);
	}

	public Sede actualizarSede(Integer id, Sede sede) {
		sede.setIdSede(id);
		return repositorio.save(sede);
	}

	public void eliminarSede(Integer id) {
		repositorio.deleteById(id);
	}
}
