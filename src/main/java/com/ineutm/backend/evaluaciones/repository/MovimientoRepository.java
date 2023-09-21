package com.ineutm.backend.evaluaciones.repository;

import com.ineutm.backend.evaluaciones.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovimientoRepository extends ReactiveCrudRepository<Movimiento, Long> {

    Flux<Movimiento> findByIdCuenta(Long idCuenta);
}
