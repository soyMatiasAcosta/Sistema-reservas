package com.cibertec.usuario.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", length = 100, nullable = false)
    private String nombreUsuario;

    @Column(name = "apellido_usuario", length = 100, nullable = false)
    private String apellidoUsuario;

    @Column(name = "correo_institucional", length = 60, unique = true, nullable = false)
    private String correoInstitucional;

    @Column(name = "codigo_institucional", length = 20, unique = true, nullable = false)
    private String codigoInstitucional;

    @Column(name = "contrasena", length = 200, nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera carrera;

    @Column(name = "id_admin_sede_check")
    private Integer idAdminSedeCheck; // si es INT y puede ser NULL
}