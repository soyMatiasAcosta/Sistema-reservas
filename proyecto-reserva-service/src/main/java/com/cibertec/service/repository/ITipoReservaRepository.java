package com.cibertec.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.service.model.TipoReserva;

@Repository
public interface ITipoReservaRepository extends JpaRepository<TipoReserva, Integer>{

}
