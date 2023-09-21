package com.ineutm.backend.evaluaciones.service.impl;

import com.ineutm.backend.evaluaciones.entity.Cuenta;
import com.ineutm.backend.evaluaciones.entity.Usuario;
import com.ineutm.backend.evaluaciones.model.CuentaDTO;
import com.ineutm.backend.evaluaciones.model.UsuarioDTO;
import com.ineutm.backend.evaluaciones.repository.UsuarioRepository;
import com.ineutm.backend.evaluaciones.service.UsuarioService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Mono<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .map(this::mapToUsuarioDTO);
    }

    @Override
    public Mono<UsuarioDTO> getUsuarioByNumeroDocumento(String numeroDocumento) {
        return usuarioRepository.findByNumeroDocumento(numeroDocumento)
                .map(this::mapToUsuarioDTO);
    }

    private UsuarioDTO mapToUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setNumeroDocumento(usuario.getNumeroDocumento());
        dto.setEstado(usuario.getEstado());
        dto.setTipo(usuario.getTipo());
        return dto;
    }

}
