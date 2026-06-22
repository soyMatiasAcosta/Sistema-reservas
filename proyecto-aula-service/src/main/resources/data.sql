INSERT IGNORE INTO tbl_sede (id_sede, nombre, direccion, estado) VALUES (1, 'Sede Cibertec Lima Centro', 'Av. Uruguay 514, Cercado de Lima', true);

INSERT IGNORE INTO tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) VALUES (1, 'Cómputo', 'Laboratorio con PCs', true);
INSERT IGNORE INTO tbl_tipo_aula (id_tipo_aula, nombre, descripcion, estado) VALUES (2, 'Audiovisual', 'Salón de grabación', true);

INSERT IGNORE INTO tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) VALUES (1, 'LAB-101', 'Laboratorio de Desarrollo', 30, 1, 1, true);
INSERT IGNORE INTO tbl_aula (id_aula, codigo, nombre, capacidad, id_sede, id_tipo_aula, estado) VALUES (2, 'AUD-201', 'Sala de Conferencias', 20, 1, 2, true);


INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (1, '08:00:00', '09:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (2, '09:30:00', '11:00:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (3, '11:00:00', '12:30:00', true);
INSERT IGNORE INTO tbl_horario (id_horario, hora_inicio, hora_fin, estado) VALUES (4, '13:00:00', '14:30:00', true);


INSERT IGNORE INTO tbl_clases (id_clase, nombre, fecha, id_aula, id_horario) VALUES (1, 'Desarrollo de Aplicaciones Web II', '2026-06-29', 1, 1);