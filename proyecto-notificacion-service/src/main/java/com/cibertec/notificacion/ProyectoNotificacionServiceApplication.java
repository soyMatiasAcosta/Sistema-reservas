package com.cibertec.notificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProyectoNotificacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoNotificacionServiceApplication.class, args);
	}

}
