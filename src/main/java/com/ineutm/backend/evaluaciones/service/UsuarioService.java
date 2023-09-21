package com.ineutm.backend.evaluaciones.service;

import com.ineutm.backend.evaluaciones.model.UsuarioDTO;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Mono<UsuarioDTO> getUsuarioById(Long id);
    Mono<UsuarioDTO> getUsuarioByNumeroDocumento(String numeroDocumento);
}
