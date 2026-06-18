package com.cibertec.service.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.service.dto.ReservaRequestDTO;
import com.cibertec.service.dto.ReservaResponseDTO;
import com.cibertec.service.model.Reserva;
import com.cibertec.service.repository.IReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private IReservaRepository repoReserva;
	
	
	private static final int ESTADO_PENDIENTE = 1;
    private static final int ESTADO_APROBADA = 2;
    private static final int ESTADO_RECHAZADA = 3;
	
	
    
    private ReservaResponseDTO convertirADTO(Reserva reserva) {
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.setIdReserva(reserva.getIdReserva());
        dto.setFechaReserva(reserva.getFechaReserva());
        dto.setFechaSolicitud(reserva.getFechaSolicitud());
        dto.setIdUsuario(reserva.getIdUsuario());
        dto.setIdAula(reserva.getIdAula());
        dto.setIdSede(reserva.getIdSede());
        dto.setIdHorario(reserva.getIdHorario());
        dto.setIdEstadoReserva(reserva.getIdEstadoReserva());
        dto.setIdTipoReserva(reserva.getIdTipoReserva());
        return dto;
    }
    
    
    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setFechaSolicitud(LocalDateTime.now());
        reserva.setIdUsuario(dto.getIdUsuario());
        reserva.setIdAula(dto.getIdAula());
        reserva.setIdSede(dto.getIdSede());
        reserva.setIdHorario(dto.getIdHorario());
        reserva.setIdTipoReserva(dto.getIdTipoReserva());
        reserva.setIdEstadoReserva(ESTADO_PENDIENTE);

        Reserva guardada = repoReserva.save(reserva);
        return convertirADTO(guardada);
    }
	
    
    public List<ReservaResponseDTO> listarTodas() {
        return repoReserva.findAll().stream().map(this::convertirADTO).toList();
    }

    public ReservaResponseDTO obtenerPorId(Integer id) {
        Reserva reserva = repoReserva.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return convertirADTO(reserva);
    }

    public List<ReservaResponseDTO> listarPorUsuario(Integer idUsuario) {
        return repoReserva.findByIdUsuario(idUsuario).stream().map(this::convertirADTO).toList();
    }

    public List<ReservaResponseDTO> listarPendientes() {
        return repoReserva.findByIdEstadoReserva(ESTADO_PENDIENTE).stream().map(this::convertirADTO).toList();
    }

    public ReservaResponseDTO aprobarReserva(Integer id) {
        Reserva reserva = repoReserva.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setIdEstadoReserva(ESTADO_APROBADA);
        return convertirADTO(repoReserva.save(reserva));
    }

    public ReservaResponseDTO rechazarReserva(Integer id) {
        Reserva reserva = repoReserva.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setIdEstadoReserva(ESTADO_RECHAZADA);
        return convertirADTO(repoReserva.save(reserva));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
