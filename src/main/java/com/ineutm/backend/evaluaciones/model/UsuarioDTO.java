package com.ineutm.backend.evaluaciones.model;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String numeroDocumento;
    private int estado;
    private String tipo;
}
