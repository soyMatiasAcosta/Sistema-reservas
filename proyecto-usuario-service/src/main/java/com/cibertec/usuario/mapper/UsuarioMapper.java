package com.cibertec.usuario.mapper;



import com.cibertec.usuario.dto.request.UsuarioRequestDTO;
import com.cibertec.usuario.dto.response.UsuarioResponseDTO;
import com.cibertec.usuario.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

    @Mapping(target = "nombreRol", source = "rol.nombreRol")
    @Mapping(target = "nombreSede", source = "sede.nombreSede")
    @Mapping(target = "nombreCarrera", source = "carrera.nombreCarrera")
    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "rol", source = "idRol", qualifiedByName = "idToRol")
    @Mapping(target = "sede", source = "idSede", qualifiedByName = "idToSede")
    @Mapping(target = "carrera", source = "idCarrera", qualifiedByName = "idToCarrera")
    Usuario toEntity(UsuarioRequestDTO requestDTO);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "rol", source = "idRol", qualifiedByName = "idToRol")
    @Mapping(target = "sede", source = "idSede", qualifiedByName = "idToSede")
    @Mapping(target = "carrera", source = "idCarrera", qualifiedByName = "idToCarrera")
    void updateEntity(UsuarioRequestDTO requestDTO, @MappingTarget Usuario usuario);

    @Named("idToRol")
    default Rol idToRol(Long id) {
        if (id == null) return null;
        Rol rol = new Rol();
        rol.setIdRol(id);
        return rol;
    }

    @Named("idToSede")
    default Sede idToSede(Long id) {
        if (id == null) return null;
        Sede sede = new Sede();
        sede.setIdSede(id);
        return sede;
    }

    @Named("idToCarrera")
    default Carrera idToCarrera(Long id) {
        if (id == null) return null;
        Carrera carrera = new Carrera();
        carrera.setIdCarrera(id);
        return carrera;
    }
}