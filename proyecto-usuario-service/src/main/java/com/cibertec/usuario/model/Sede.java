package com.cibertec.usuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_sede")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Sede")
    private Long idSede;

    @Column(name = "nombre_sede", length = 100)
    private String nombreSede;

    @Column(name = "direccion_sede", length = 50)
    private String direccionSede;
}