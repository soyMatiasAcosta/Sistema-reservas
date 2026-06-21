package com.cibertec.aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_aula")
public class Aula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAula;
	private String codigo;
	private String nombre;
	private Integer capacidad;
	private Integer idSede;
	private Integer idTipoAula;
	private boolean estado;
	
}
