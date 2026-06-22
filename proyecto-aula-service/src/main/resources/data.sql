INSERT IGNORE INTO tbl_sede (id_sede, nombre, direccion, estado) VALUES (1, 'Sede Cibertec Lima Centro', 'Av. Uruguay 514, Cercado de Lima', true);

INSERT IGNORE INTO tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) VALUES (1, 'Cómputo', 'Laboratorio con PCs', true);
INSERT IGNORE INTO tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) VALUES (2, 'Audiovisual', 'Salón de grabación', true);

INSERT IGNORE INTO tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) VALUES (1, 'LAB-101', 'Laboratorio de Desarrollo', 30, 1, 1, true);
INSERT IGNORE INTO tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) VALUES (2, 'AUD-201', 'Sala de Conferencias', 20, 1, 2, true);


INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (1, '07:00:00', '08:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (2, '08:30:00', '10:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (3, '10:00:00', '11:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (4, '11:30:00', '13:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (5, '13:00:00', '14:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (6, '14:30:00', '16:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (7, '16:00:00', '17:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (8, '17:30:00', '19:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (9, '19:00:00', '20:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (10, '20:30:00', '22:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (11, '22:00:00', '22:45:00', true);

INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (1, 'Desarrollo de Aplicaciones Web II', '2026-06-29', 1, 1);
INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (2, 'Desarrollo de Aplicaciones Web II', '2026-06-29', 1, 2);


INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (3, 'Ingeniería de Requerimientos', '2026-06-29', 2, 9);

INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (4, 'Desarrollo de Aplicaciones Móviles', '2026-06-30', 1, 6);

INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (5, 'Experiencia de Usuario (UX)', '2026-07-01', 2, 3);