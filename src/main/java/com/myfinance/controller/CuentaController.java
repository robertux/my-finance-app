package com.myfinance.controller;

import com.myfinance.model.Cuenta;
import com.myfinance.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable(value = "id") Long cuentaId) {
        Cuenta cuenta = cuentaService.getCuentaById(cuentaId);
        return ResponseEntity.ok().body(cuenta);
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.createCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable(value = "id") Long cuentaId, @RequestBody Cuenta cuentaDetails) {
        Cuenta updatedCuenta = cuentaService.updateCuenta(cuentaId, cuentaDetails);
        return ResponseEntity.ok(updatedCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable(value = "id") Long cuentaId) {
        cuentaService.deleteCuenta(cuentaId);
        return ResponseEntity.noContent().build();
    }
}