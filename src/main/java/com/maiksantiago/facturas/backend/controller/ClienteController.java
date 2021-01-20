package com.maiksantiago.facturas.backend.controller;

import com.maiksantiago.facturas.backend.model.entity.Cliente;
import com.maiksantiago.facturas.backend.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends CommonController<Cliente, ClienteService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Cliente cliente, BindingResult result,
                                        @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Cliente clienteActual = this.service.findById(id);
        if (clienteActual == null) {
            return ResponseEntity.noContent().build();
        }
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setDireccion(cliente.getDireccion());
        clienteActual.setTelefono(cliente.getTelefono());
        clienteActual.setCorreoElectronico(cliente.getCorreoElectronico());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(clienteActual));
    }

}