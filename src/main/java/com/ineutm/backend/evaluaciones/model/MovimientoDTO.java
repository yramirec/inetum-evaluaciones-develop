package com.ineutm.backend.evaluaciones.model;

import lombok.Data;

@Data
public class MovimientoDTO {
    private Long id;
    private Long idCuenta;
    private String descripcion;
    private Double intereses;
}
