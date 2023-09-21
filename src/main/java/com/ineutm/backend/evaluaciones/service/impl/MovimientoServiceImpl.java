package com.ineutm.backend.evaluaciones.service.impl;

import com.ineutm.backend.evaluaciones.entity.Movimiento;
import com.ineutm.backend.evaluaciones.model.MovimientoDTO;
import com.ineutm.backend.evaluaciones.repository.MovimientoRepository;
import com.ineutm.backend.evaluaciones.service.MovimientoService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Flux<MovimientoDTO> getMovimientosByCuentaId(Long idCuenta) {
        return movimientoRepository.findByIdCuenta(idCuenta)
                .map(this::mapToMovimientoDTO);
    }

    private MovimientoDTO mapToMovimientoDTO(Movimiento movimiento) {
        MovimientoDTO dto = new MovimientoDTO();
        dto.setId(movimiento.getId());
        dto.setIdCuenta(movimiento.getIdCuenta());
        dto.setDescripcion(movimiento.getDescripcion());
        dto.setIntereses(movimiento.getIntereses());
        return dto;
    }
}
