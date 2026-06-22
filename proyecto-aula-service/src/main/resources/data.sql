insert ignore into tbl_sede (id_sede, nombre, direccion, estado) values (1, 'Sede Cibertec Lima Centro', 'Av. Uruguay 514, Cercado de Lima', true);

insert ignore into tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) values (1, 'Cómputo', 'Laboratorio con PCs', true);
insert ignore into tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) values (2, 'Audiovisual', 'Salón de grabación', true);

insert ignore into tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) values (1, 'LAB-101', 'Laboratorio de Desarrollo', 30, 1, 1, true);
insert ignore into tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) values (2, 'AUD-201', 'Sala de Conferencias', 20, 1, 2, true);


insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (1, '07:00:00', '08:30:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (2, '08:30:00', '10:00:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (3, '10:00:00', '11:30:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (4, '11:30:00', '13:00:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (5, '13:00:00', '14:30:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (6, '14:30:00', '16:00:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (7, '16:00:00', '17:30:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (8, '17:30:00', '19:00:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (9, '19:00:00', '20:30:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (10, '20:30:00', '22:00:00', true);
insert ignore into tbl_horario (id_horario, hora_inicio, hora_fin, estado) values (11, '22:00:00', '22:45:00', true);

insert ignore into tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) values (1, 'Desarrollo de Aplicaciones Web II', '2026-06-29', 1, 1);
insert ignore into tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) values (2, 'Desarrollo de Aplicaciones Web II', '2026-06-29', 1, 2);


insert ignore into tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) values (3, 'Ingeniería de Requerimientos', '2026-06-29', 2, 9);

insert ignore into tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) values (4, 'Desarrollo de Aplicaciones Móviles', '2026-06-30', 1, 6);

insert ignore into tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) values (5, 'Experiencia de Usuario (UX)', '2026-07-01', 2, 3);