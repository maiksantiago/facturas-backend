package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Factura;
import com.maiksantiago.facturas.backend.model.entity.Item;
import com.maiksantiago.facturas.backend.model.entity.Producto;
import com.maiksantiago.facturas.backend.service.FacturaService;
import com.maiksantiago.facturas.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController extends CommonController<Factura, FacturaService> {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Factura factura, BindingResult result) {
        Factura nuevaFactura = null;
        if (result.hasErrors()) {
            return this.validar(result);
        }
        try {
            nuevaFactura = this.service.save(factura);
            for (Item item : factura.getItems()) {
                Producto producto = this.productoService.findById(item.getProducto().getId());
                producto.setStock(item.getProducto().getStock() - item.getCantidad());
                this.productoService.save(producto);
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFactura);
    }

}