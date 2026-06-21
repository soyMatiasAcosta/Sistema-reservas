package com.cibertec.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.aula.model.TipoAula;
import com.cibertec.aula.repository.ITipoAula;

@Service
public class TipoAulaServices {

	@Autowired
	private ITipoAula repositorio;

	public List<TipoAula> listarTiposAula() {
		return repositorio.findByEstadoTrue();
	}

	public TipoAula obtenerTipoAulaPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public TipoAula registrarTipoAula(TipoAula tipoAula) {
		tipoAula.setEstado(true);
		return repositorio.save(tipoAula);
	}

	public TipoAula actualizarTipoAula(Integer id, TipoAula tipoAula) {
		tipoAula.setIdTipoAula(id);
		return repositorio.save(tipoAula);
	}

	public void eliminarTipoAula(Integer id) {
		repositorio.deleteById(id);
	}
}
