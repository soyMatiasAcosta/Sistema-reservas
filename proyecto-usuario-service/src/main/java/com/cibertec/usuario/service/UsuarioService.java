package com.cibertec.usuario.service;


import com.cibertec.usuario.dto.request.UsuarioRequestDTO;
import com.cibertec.usuario.dto.response.UsuarioResponseDTO;
import com.cibertec.usuario.model.Usuario;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO create(UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO update(Long id, UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO findById(Long id);
    Usuario findByEmail(String email);
    List<UsuarioResponseDTO> findAll();
    void delete(Long id);
    boolean existsByEmail(String email);
    boolean existsByCodigo(String codigo);
}