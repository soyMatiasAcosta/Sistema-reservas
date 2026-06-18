package com.cibertec.service.services;

import com.cibertec.service.dto.EstadoReservaDTO;
import com.cibertec.service.model.EstadoReserva;
import com.cibertec.service.repository.IEstadoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoReservaService {

    @Autowired
    private IEstadoReservaRepository repoEstadoReserva;

    public List<EstadoReservaDTO> listarEstados() {
        return repoEstadoReserva.findAll().stream().map(this::convertirADTO)
        		.toList();
    }

    public EstadoReservaDTO obtenerPorId(Integer id) {
        EstadoReserva estado = repoEstadoReserva.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de reserva no encontrado"));
        return convertirADTO(estado);
    }

    private EstadoReservaDTO convertirADTO(EstadoReserva estado) {
        EstadoReservaDTO dto = new EstadoReservaDTO();
        dto.setIdEstadoReserva(estado.getIdEstadoReserva());
        dto.setDescripcion(estado.getDescripcion());
        return dto;
    }
    
}
