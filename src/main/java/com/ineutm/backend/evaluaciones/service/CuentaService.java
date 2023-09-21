package com.ineutm.backend.evaluaciones.service;

import com.ineutm.backend.evaluaciones.model.CuentaDTO;
import reactor.core.publisher.Mono;

public interface CuentaService {
    Mono<CuentaDTO> getCuentaById(Long id);
    Mono<CuentaDTO> getCuentaByNumero(String numero);
}
