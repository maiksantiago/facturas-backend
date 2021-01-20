package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Factura;
import com.maiksantiago.facturas.backend.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController extends CommonController<Factura, FacturaService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Factura factura, BindingResult result,
                                        @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Factura facturaActual = this.service.findById(id);
        if (facturaActual == null) {
            return ResponseEntity.noContent().build();
        }
        facturaActual.setFechaEmision(factura.getFechaEmision());
        facturaActual.setCliente(factura.getCliente());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(facturaActual));
    }

}