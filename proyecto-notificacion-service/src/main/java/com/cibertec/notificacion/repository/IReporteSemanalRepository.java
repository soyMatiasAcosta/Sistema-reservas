package com.cibertec.notificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.notificacion.model.ReporteSemanal;

@Repository
public interface IReporteSemanalRepository extends JpaRepository<ReporteSemanal, Integer>{

}
