package com.cibertec.notificacion.rabbit;

import com.cibertec.notificacion.dto.ReservaEventoDTO;
import com.cibertec.notificacion.model.Incidencia;
import com.cibertec.notificacion.repository.IIncidenciaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservaConsumidor {

    @Autowired
    private IIncidenciaRepository repoIncidencia;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumirEvento(ReservaEventoDTO evento) {
        System.out.println("Evento recibido de RabbitMQ: "
                + evento.getTipoEvento()
                + " - Reserva #" + evento.getIdReserva());

        Incidencia incidencia = new Incidencia();
        incidencia.setFechaGeneracion(LocalDateTime.now());
        incidencia.setIdUsuario(evento.getIdUsuario());
        incidencia.setIdAula(evento.getIdAula());

        switch (evento.getTipoEvento()) {
            case "CREADA" -> {
                incidencia.setAsunto("Reserva registrada");
                incidencia.setDescripcion(
                    "El usuario " + evento.getIdUsuario() +
                    " registró una reserva para el aula " + evento.getIdAula() +
                    " el " + evento.getFechaReserva() +
                    ". Estado: Pendiente de aprobación."
                );
            }
            case "APROBADA" -> {
                incidencia.setAsunto("Reserva aprobada");
                incidencia.setDescripcion(
                    "La reserva #" + evento.getIdReserva() +
                    " del usuario " + evento.getIdUsuario() +
                    " fue aprobada para el aula " + evento.getIdAula() +
                    " el " + evento.getFechaReserva() + "."
                );
            }
            case "RECHAZADA" -> {
                incidencia.setAsunto("Reserva rechazada");
                incidencia.setDescripcion(
                    "La reserva #" + evento.getIdReserva() +
                    " del usuario " + evento.getIdUsuario() +
                    " fue rechazada para el aula " + evento.getIdAula() +
                    " el " + evento.getFechaReserva() + "."
                );
            }
            default -> {
                incidencia.setAsunto("Evento desconocido");
                incidencia.setDescripcion("Tipo de evento no reconocido: " + evento.getTipoEvento());
            }
        }

        repoIncidencia.save(incidencia);
        System.out.println("Incidencia registrada en BD: " + incidencia.getAsunto());
    }
    
}