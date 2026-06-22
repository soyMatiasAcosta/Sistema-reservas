insert ignore into tbl_rol (id_rol, nombre_rol) values (1, 'ADMIN');
insert ignore into tbl_rol (id_rol, nombre_rol) values (2, 'ESTUDIANTE');

insert ignore into tbl_sede (id_sede, nombre_sede, direccion_sede) values (1, 'Sede Cibertec Lima Centro', 'Av. Uruguay 514, Cercado de Lima');

insert ignore into tbl_carrera (id_carrera, nombre_carrera) values (1, 'Computación e Informática');
insert ignore into tbl_carrera (id_carrera, nombre_carrera) values (2, 'Administración de Redes');
insert ignore into tbl_carrera (id_carrera, nombre_carrera) values (3, 'Dirección audiovisual');


insert ignore into tbl_usuario (id_usuario, nombre_usuario, apellido_usuario, correo_institucional, codigo_institucional, contrasena, id_rol, id_sede, id_carrera, id_admin_sede_check) 
values (1, 'Admin', 'Sistemas', 'admin@cibertec.edu.pe', 'ADM001', '$2a$10$T8Z6iGqX2Z/7uH7oN4yNnOq2SgT6e.P1Y6X.8X1i0hN6V8V3UeGqe', 1, 1, 1, 1);

insert ignore into tbl_usuario (id_usuario, nombre_usuario, apellido_usuario, correo_institucional, codigo_institucional, contrasena, id_rol, id_sede, id_carrera, id_admin_sede_check) 
values (2, 'Matias', 'Compañero', 'acosta@cibertec.edu.pe', 'I20230001', '$2a$10$T8Z6iGqX2Z/7uH7oN4yNnOq2SgT6e.P1Y6X.8X1i0hN6V8V3UeGqe', 2, 1, 1, NULL);