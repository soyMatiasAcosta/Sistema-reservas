package com.cibertec.aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_carrera_tipo_aula")
public class CarreraTipoAula {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_carrera_tipo_aula;
	private Integer id_carrera;
	private Integer id_tipo_aula; 
	
}
