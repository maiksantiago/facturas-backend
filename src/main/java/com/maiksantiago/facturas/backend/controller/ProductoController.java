package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Producto;
import com.maiksantiago.facturas.backend.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController extends CommonController<Producto, ProductoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Producto producto, BindingResult result,
                                        @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Producto productoActual = this.service.findById(id);
        if (productoActual == null) {
            return ResponseEntity.noContent().build();
        }
        productoActual.setNombre(producto.getNombre());
        productoActual.setPrecio(producto.getPrecio());
        productoActual.setStock(producto.getStock());
        productoActual.setCategoria(producto.getCategoria());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(productoActual));
    }

    @GetMapping("/filtrar/{nombre}")
    public ResponseEntity<?> filtrarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.findByNombre(nombre));
    }

}