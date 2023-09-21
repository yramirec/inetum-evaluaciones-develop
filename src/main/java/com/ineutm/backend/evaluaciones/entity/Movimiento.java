package com.ineutm.backend.evaluaciones.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MOVIMIENTO")
@Data
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCuenta;

    private String descripcion;

    private Double intereses;
}
