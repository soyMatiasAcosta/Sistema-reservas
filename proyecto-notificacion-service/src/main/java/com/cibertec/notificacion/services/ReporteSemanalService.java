package com.cibertec.notificacion.services;

import com.cibertec.notificacion.dto.ReporteSemanalDTO;
import com.cibertec.notificacion.model.ReporteSemanal;
import com.cibertec.notificacion.repository.IReporteSemanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteSemanalService {

    @Autowired
    private IReporteSemanalRepository repoReporte;

    
    public List<ReporteSemanalDTO> listarTodos() {
        return repoReporte.findAll().stream().map(this::convertirADTO).toList();
    }
    

    public ReporteSemanalDTO obtenerPorId(Integer id) {
    	
        ReporteSemanal reporte = repoReporte.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        return convertirADTO(reporte);
    }

    
    private ReporteSemanalDTO convertirADTO(ReporteSemanal reporte) {
    	
        ReporteSemanalDTO dto = new ReporteSemanalDTO();
        dto.setIdReporte(reporte.getIdReporte());
        dto.setFechaGeneracion(reporte.getFechaGeneracion());
        dto.setFechaInicioSemana(reporte.getFechaInicioSemana());
        dto.setFechaFinSemana(reporte.getFechaFinSemana());
        dto.setTotalReservas(reporte.getTotalReservas());
        dto.setIdAdmin(reporte.getIdAdmin());
        return dto;
    }
    
}


