package com.cibertec.notificacion.services;

import com.cibertec.notificacion.dto.IncidenciaResponseDTO;
import com.cibertec.notificacion.model.Incidencia;
import com.cibertec.notificacion.repository.IIncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IIncidenciaRepository repoIncidencia;

    public List<IncidenciaResponseDTO> listarTodas() {
    	
        return repoIncidencia.findAll().stream().map(this::convertirADTO).toList();
        
    }

    public List<IncidenciaResponseDTO> listarPorUsuario(Integer idUsuario) {
    	
        return repoIncidencia.findByIdUsuario(idUsuario).stream().map(this::convertirADTO).toList();
        
    }

    public IncidenciaResponseDTO obtenerPorId(Integer id) {
    	
        Incidencia incidencia = repoIncidencia.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));
        return convertirADTO(incidencia);
        
    }
    

    private IncidenciaResponseDTO convertirADTO(Incidencia incidencia) {
    	
        IncidenciaResponseDTO dto = new IncidenciaResponseDTO();
        dto.setIdIncidencia(incidencia.getIdIncidencia());
        dto.setAsunto(incidencia.getAsunto());
        dto.setDescripcion(incidencia.getDescripcion());
        dto.setFechaGeneracion(incidencia.getFechaGeneracion());
        dto.setIdUsuario(incidencia.getIdUsuario());
        dto.setIdAula(incidencia.getIdAula());
        return dto;
    }
    
}