package com.ineutm.backend.evaluaciones.service;

import com.ineutm.backend.evaluaciones.model.MovimientoDTO;
import reactor.core.publisher.Flux;

public interface MovimientoService {
    Flux<MovimientoDTO> getMovimientosByCuentaId(Long idCuenta);
}
