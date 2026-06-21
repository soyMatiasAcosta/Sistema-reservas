INSERT INTO tbl_estado_reserva (id_estado_reserva, descripcion) VALUES
(1, 'Pendiente'),
(2, 'Aprobada'),
(3, 'Rechazada');


INSERT INTO tbl_tipo_reserva (id_tipo_reserva, descripcion) VALUES
(1, 'Individual'),
(2, 'Grupal');



INSERT INTO tbl_estado_reserva (id_estado_reserva, descripcion) VALUES
(1, 'Pendiente'),
(2, 'Aprobada'),
(3, 'Rechazada');

-- Tipos de reserva (ajusta según lo que definieron en el equipo)
INSERT INTO tbl_tipo_reserva (id_tipo_reserva, descripcion) VALUES
(1, 'Individual'),
(2, 'Grupal');



select * from tbl_aula;
select * from tbl_tipo_aula;
select * from tbl_horario;
select * from tbl_sede;



USE aula_service;
INSERT INTO tbl_sede (nombre, direccion, estado) VALUES ('Sede San Juan de Lurigancho', 'Av. Próceres', true);
INSERT INTO tbl_tipo_aula (nombre, descripcion, estado) VALUES ('Cómputo', 'Aula con computadoras', true);

INSERT IGNORE INTO tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) 
VALUES (2, 'Audiovisual', 'Aula con proyector y sonido', true);
