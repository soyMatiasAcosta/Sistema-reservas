package com.cibertec.service.services;

import com.cibertec.service.dto.TipoReservaDTO;
import com.cibertec.service.model.TipoReserva;
import com.cibertec.service.repository.ITipoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoReservaService {

    @Autowired
    private ITipoReservaRepository repoTipoReserva;

    public List<TipoReservaDTO> listarTipos() {
        return repoTipoReserva.findAll().stream().map(this::convertirADTO)
        		.toList();
    }

    public TipoReservaDTO obtenerPorId(Integer id) {
        TipoReserva tipo = repoTipoReserva.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de reserva no encontrado"));
        return convertirADTO(tipo);
    }

    private TipoReservaDTO convertirADTO(TipoReserva tipo) {
        TipoReservaDTO dto = new TipoReservaDTO();
        dto.setIdTipoReserva(tipo.getIdTipoReserva());
        dto.setDescripcion(tipo.getDescripcion());
        return dto;
    }
    
}