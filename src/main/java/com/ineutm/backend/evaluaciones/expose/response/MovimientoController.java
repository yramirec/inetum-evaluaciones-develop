package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.model.MovimientoDTO;
import com.ineutm.backend.evaluaciones.service.MovimientoService;
import com.ineutm.backend.evaluaciones.service.impl.MovimientoServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/movimientos")
@Validated
public class MovimientoController {
    private final MovimientoServiceImpl movimientoServiceImpl;

    public MovimientoController(MovimientoServiceImpl movimientoServiceImpl) {
        this.movimientoServiceImpl = movimientoServiceImpl;
    }

    // Obtener movimientos por ID de cuenta
    @GetMapping("/{idCuenta}")
    public Flux<MovimientoDTO> getMovimientosByCuentaId(@PathVariable Long idCuenta) {
        return movimientoServiceImpl.getMovimientosByCuentaId(idCuenta);
    }
}
