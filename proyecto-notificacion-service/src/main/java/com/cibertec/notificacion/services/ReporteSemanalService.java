package com.cibertec.notificacion.services;

import com.cibertec.notificacion.dto.ReporteSemanalDTO;
import com.cibertec.notificacion.model.Incidencia;
import com.cibertec.notificacion.model.ReporteSemanal;
import com.cibertec.notificacion.repository.IIncidenciaRepository;
import com.cibertec.notificacion.repository.IReporteSemanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class ReporteSemanalService {

    @Autowired
    private IReporteSemanalRepository repoReporte;

    @Autowired
    private IIncidenciaRepository repoIncidencia;
    
    
    public List<ReporteSemanalDTO> listarTodos() {
        return repoReporte.findAll().stream().map(this::convertirADTO).toList();
    }
    

    public ReporteSemanalDTO obtenerPorId(Integer id) {
    	
        ReporteSemanal reporte = repoReporte.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        return convertirADTO(reporte);
    }

    
    public ReporteSemanalDTO generarReporteSemanal(Integer idAdmin) {

        LocalDate hoy          = LocalDate.now();
        LocalDate inicioSemana = hoy.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate finSemana    = hoy.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        List<Incidencia> incidenciasSemana = repoIncidencia.findAll().stream()
                .filter(i -> {
                    LocalDate fechaIncidencia = i.getFechaGeneracion().toLocalDate();
                    return !fechaIncidencia.isBefore(inicioSemana)
                        && !fechaIncidencia.isAfter(finSemana);
                })
                .toList();

        int totalReservas = incidenciasSemana.size();

        ReporteSemanal reporte = repoReporte.findAll().stream()
                .filter(r -> r.getFechaInicioSemana().equals(inicioSemana))
                .findFirst()
                .orElse(null);

        if (reporte == null) {
            reporte = new ReporteSemanal();
            reporte.setFechaInicioSemana(inicioSemana);
            reporte.setFechaFinSemana(finSemana);
        }

        reporte.setFechaGeneracion(LocalDateTime.now());
        reporte.setTotalReservas(totalReservas);
        reporte.setIdAdmin(idAdmin);

        repoReporte.save(reporte);
        System.out.println("Reporte generado: " + totalReservas
                + " reservas entre " + inicioSemana + " y " + finSemana);

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


