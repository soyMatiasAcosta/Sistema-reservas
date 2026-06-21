package com.cibertec.aula.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_clases")
public class Clase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClase;
	private String nombre;
	private LocalDate fecha;
	private Integer idAula;
	private Integer idHorario;
}
