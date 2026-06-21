package com.cibertec.aula.service;
	
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.aula.dto.DisponibilidadResponse;
import com.cibertec.aula.model.Aula;
import com.cibertec.aula.repository.IAula;
import com.cibertec.aula.repository.IClase;

import org.springframework.transaction.annotation.Transactional;
	
	@Service
	public class AulaServices {

		private final IAula repositorio;
		private final IClase repoClase;

	    public AulaServices(IAula repositorio, IClase repoClase) {
	        this.repositorio = repositorio;
	        this.repoClase = repoClase;
	    }

	    public List<Aula> listarAulas() {
	        return repositorio.findByEstadoTrue();
	    }

	    public Aula obtenerAulaPorId(Integer id) {
	        return repositorio.findById(id).orElse(null);
	    }

	    public Aula registrarAula(Aula aula) {
	        return repositorio.save(aula);
	    }

	    public Aula actualizarAula(Integer id, Aula aula) {
	        aula.setIdAula(id);
	        return repositorio.save(aula);
	    }

	    @Transactional
	    public void eliminarAula(Integer id) {
	        repositorio.eliminarLogico(id);
	    }

	    public DisponibilidadResponse verificarDisponibilidad(Integer idAula, Integer idHorario, LocalDate fecha) {
	        long total = repoClase.countByIdAulaAndIdHorarioAndFecha(idAula, idHorario, fecha);
	        boolean disponible = total == 0;

	        DisponibilidadResponse response = new DisponibilidadResponse();
	        response.setIdAula(idAula);
	        response.setIdHorario(idHorario);
	        response.setFecha(fecha.toString());
	        response.setDisponible(disponible);
	        response.setMensaje(disponible ? "LIBRE" : "OCUPADA");

	        return response;
	    }
	}
