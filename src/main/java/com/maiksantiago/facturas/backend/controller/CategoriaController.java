package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Categoria;
import com.maiksantiago.facturas.backend.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController extends CommonController<Categoria, CategoriaService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Categoria categoria, BindingResult result,
                                        @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Categoria categoriaActual = this.service.findById(id);
        if (categoriaActual == null) {
            return ResponseEntity.noContent().build();
        }
        categoriaActual.setNombre(categoria.getNombre());
        categoriaActual.setDescripcion(categoria.getDescripcion());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(categoriaActual));
    }

}