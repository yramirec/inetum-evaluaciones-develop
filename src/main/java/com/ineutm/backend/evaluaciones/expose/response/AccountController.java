package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.model.CuentaDTO;
import com.ineutm.backend.evaluaciones.service.CuentaService;
import com.ineutm.backend.evaluaciones.service.impl.CuentaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@Slf4j
@Validated // Habilitar la validación de expresiones regulares
public class AccountController {

  private final CuentaServiceImpl cuentaServiceimpl;

  public AccountController(CuentaServiceImpl cuentaServiceimpl) {
    this.cuentaServiceimpl = cuentaServiceimpl;
  }


  @GetMapping("/{id}")
  public Mono<ResponseEntity<CuentaDTO>> getCuentaById(@PathVariable Long id) {
    return cuentaServiceimpl.getCuentaById(id)
            .map(cuenta -> ResponseEntity.ok(cuenta))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  // Obtener una cuenta por número
  @GetMapping
  public Mono<ResponseEntity<CuentaDTO>> getCuentaByNumero(@RequestParam String numero) {
    return cuentaServiceimpl.getCuentaByNumero(numero)
            .map(cuenta -> ResponseEntity.ok(cuenta))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
}
