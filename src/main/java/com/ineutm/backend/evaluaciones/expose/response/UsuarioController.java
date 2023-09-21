package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.model.UsuarioDTO;
import com.ineutm.backend.evaluaciones.service.UsuarioService;
import com.ineutm.backend.evaluaciones.service.impl.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/usuarios")
@Validated // Habilitar la validación de expresiones regulares
public class UsuarioController {
    private final UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }


    @GetMapping("/{id}")
    public Mono<ResponseEntity<UsuarioDTO>> getUsuarioById(@PathVariable Long id) {
        return usuarioServiceImpl.getUsuarioById(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @GetMapping
    public Mono<ResponseEntity<UsuarioDTO>> getUsuarioByNumeroDocumento(
            @RequestParam @Pattern(regexp = "\\d{1,8}") String numeroDocumento) {
        return usuarioServiceImpl.getUsuarioByNumeroDocumento(numeroDocumento)
                .map(usuario -> ResponseEntity.ok(usuario))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}