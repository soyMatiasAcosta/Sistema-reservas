package com.cibertec.service.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaProductor {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publicarMensaje(ReservaEventoDTO evento) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
            RabbitMQConfig.ROUTING_KEY,evento);
        System.out.println("Evento publicado a RabbitMQ: " 
            + evento.getTipoEvento() 
            + " - Reserva #" + evento.getIdReserva());
    }
    
}