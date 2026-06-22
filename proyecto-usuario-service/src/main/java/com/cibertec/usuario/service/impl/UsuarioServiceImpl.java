package com.cibertec.usuario.service.impl;


import com.cibertec.usuario.dto.request.UsuarioRequestDTO;
import com.cibertec.usuario.dto.response.UsuarioResponseDTO;
import com.cibertec.usuario.mapper.UsuarioMapper;
import com.cibertec.usuario.model.*;
import com.cibertec.usuario.repository.*;
import com.cibertec.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final SedeRepository sedeRepository;
    private final CarreraRepository carreraRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioRequestDTO requestDTO) {

        if (usuarioRepository.existsByCorreoInstitucional(requestDTO.getCorreoInstitucional())) {
            throw new RuntimeException("El correo institucional ya está registrado");
        }
        if (usuarioRepository.existsByCodigoInstitucional(requestDTO.getCodigoInstitucional())) {
            throw new RuntimeException("El código institucional ya está registrado");
        }

        Rol rol = rolRepository.findById(requestDTO.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        Sede sede = sedeRepository.findById(requestDTO.getIdSede())
                .orElseThrow(() -> new RuntimeException("Sede no encontrada"));
        Carrera carrera = carreraRepository.findById(requestDTO.getIdCarrera())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Usuario usuario = usuarioMapper.toEntity(requestDTO);
        usuario.setRol(rol);
        usuario.setSede(sede);
        usuario.setCarrera(carrera);

        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (requestDTO.getCorreoInstitucional() != null &&
                !requestDTO.getCorreoInstitucional().equals(usuario.getCorreoInstitucional())) {
            if (usuarioRepository.existsByCorreoInstitucional(requestDTO.getCorreoInstitucional())) {
                throw new RuntimeException("El correo ya está registrado");
            }
        }
        if (requestDTO.getCodigoInstitucional() != null &&
                !requestDTO.getCodigoInstitucional().equals(usuario.getCodigoInstitucional())) {
            if (usuarioRepository.existsByCodigoInstitucional(requestDTO.getCodigoInstitucional())) {
                throw new RuntimeException("El código ya está registrado");
            }
        }

        if (requestDTO.getIdRol() != null) {
            Rol rol = rolRepository.findById(requestDTO.getIdRol())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            usuario.setRol(rol);
        }
        if (requestDTO.getIdSede() != null) {
            Sede sede = sedeRepository.findById(requestDTO.getIdSede())
                    .orElseThrow(() -> new RuntimeException("Sede no encontrada"));
            usuario.setSede(sede);
        }
        if (requestDTO.getIdCarrera() != null) {
            Carrera carrera = carreraRepository.findById(requestDTO.getIdCarrera())
                    .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
            usuario.setCarrera(carrera);
        }

        usuarioMapper.updateEntity(requestDTO, usuario);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByCorreoInstitucional(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByCorreoInstitucional(email);
    }

    @Override
    public boolean existsByCodigo(String codigo) {
        return usuarioRepository.existsByCodigoInstitucional(codigo);
    }
}