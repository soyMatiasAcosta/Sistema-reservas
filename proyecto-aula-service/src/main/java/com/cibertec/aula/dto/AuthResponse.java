package com.cibertec.aula.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	
		
		private String correo;
		private String nombre;
		private String token;
		
	

}
