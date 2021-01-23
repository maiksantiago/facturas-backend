package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Factura;
import com.maiksantiago.facturas.backend.service.FacturaService;
import com.maiksantiago.facturas.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController extends CommonController<Factura, FacturaService> {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Factura factura, BindingResult result) {
        List<String> errores = new ArrayList<>();
        Factura nuevaFactura = null;
        if (result.hasErrors()) {
            return this.validar(result);
        }
        try {
            nuevaFactura = service.save(factura);
        } catch (ConstraintViolationException exception) {
            if (exception.getClass().toString().equals("class javax.validation.ConstraintViolationException")) {
                exception.getConstraintViolations().forEach(error -> {
                    errores.add(error.getMessage());
                });
                return ResponseEntity.badRequest().body(errores);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFactura);
    }

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