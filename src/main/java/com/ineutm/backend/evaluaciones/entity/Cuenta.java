package com.ineutm.backend.evaluaciones.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CUENTA")
@Data
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int estado;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;
}
