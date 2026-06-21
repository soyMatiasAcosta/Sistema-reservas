	package com.cibertec.aula.service;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.cibertec.aula.model.Horario;
	import com.cibertec.aula.repository.IHorario;
	
	@Service
	public class HorarioServices {
	
		@Autowired
		private  IHorario repositorio;
	
	
	    public List<Horario> listarHorarios() {
	        return repositorio.findByEstadoTrue();
	    }
	
	    public Horario obtenerHorarioPorId(Integer id) {
	        return repositorio.findById(id).orElse(null);
	    }
	
	    public Horario registrarHorario(Horario horario) {
	        horario.setEstado(true);
	        return repositorio.save(horario);
	    }
	
	    public Horario actualizarHorario(Integer id, Horario horario) {
	        horario.setIdHorario(id);
	        return repositorio.save(horario);
	    }
	
	    public void eliminarHorario(Integer id) {
	        repositorio.deleteById(id);
	    }
	}
