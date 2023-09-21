package com.ineutm.backend.evaluaciones.repository;

import com.ineutm.backend.evaluaciones.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CuentaRepository extends ReactiveCrudRepository<Cuenta, Long> {
    Mono<Cuenta> findByNumero(String numero);
}
