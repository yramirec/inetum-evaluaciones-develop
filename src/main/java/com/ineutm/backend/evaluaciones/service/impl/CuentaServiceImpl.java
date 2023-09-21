package com.ineutm.backend.evaluaciones.service.impl;

import com.ineutm.backend.evaluaciones.entity.Cuenta;
import com.ineutm.backend.evaluaciones.model.CuentaDTO;
import com.ineutm.backend.evaluaciones.repository.CuentaRepository;
import com.ineutm.backend.evaluaciones.service.CuentaService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {

        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Mono<CuentaDTO> getCuentaById(Long id) {
        return cuentaRepository.findById(id)
                .map(this::mapToCuentaDTO);
    }

    @Override
    public Mono<CuentaDTO> getCuentaByNumero(String numero) {
        return cuentaRepository.findByNumero(numero)
                .map(this::mapToCuentaDTO);
    }

    private CuentaDTO mapToCuentaDTO(Cuenta cuenta) {
        CuentaDTO dto = new CuentaDTO();
        dto.setId(cuenta.getId());
        dto.setEstado(cuenta.getEstado());
        dto.setNumero(cuenta.getNumero());
        return dto;
    }
}
