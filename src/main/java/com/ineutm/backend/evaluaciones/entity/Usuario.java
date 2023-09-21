package com.ineutm.backend.evaluaciones.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String numeroDocumento;

    private int estado;

    private String tipo;
}
