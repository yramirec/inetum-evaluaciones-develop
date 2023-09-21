package com.ineutm.backend.evaluaciones.repository;

import com.ineutm.backend.evaluaciones.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {

    Mono<Usuario> findByNumeroDocumento(String numeroDocumento);
}
