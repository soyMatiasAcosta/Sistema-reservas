package com.cibertec.aula.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_horario")
public class Horario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idHorario;
	private LocalTime  horaInicio;
	private LocalTime  horaFin;
	private boolean estado;
}
