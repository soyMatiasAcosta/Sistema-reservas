package com.cibertec.usuario.repository;


import com.cibertec.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoInstitucional(String correo);
    Optional<Usuario> findByCodigoInstitucional(String codigo);
    boolean existsByCorreoInstitucional(String correo);
    boolean existsByCodigoInstitucional(String codigo);
}