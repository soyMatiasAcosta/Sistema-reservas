package com.cibertec.usuario.repository;

import com.cibertec.usuario.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
}